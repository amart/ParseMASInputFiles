/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsemasinputfiles;

import ucar.nc2.*;
import ucar.ma2.*;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Arrays;

/*
import ucar.nc2.NetcdfFileWriter;
import ucar.nc2.FileWriter2;
import ucar.nc2.NetcdfFile;
import ucar.nc2.write.Nc4Chunking;
import ucar.nc2.write.Nc4Chunking.Strategy;
*/

/**
 *
 * @author amart
 */
public class WritenetCDFOutputFile
{
    String filename = "inputdata.nc3";
    NetcdfFileWriter dataFile = null;

    public void write(final DataFileStructure dfs, final String s) throws Exception
    {
        if (dfs == null)
        {
            throw new Exception("DataFileStructure not initialized");
        }

        if (!s.isEmpty())
        {
            filename = s;
        }

        try
        {
            dfs.netCDFfilename = filename;

            dataFile = NetcdfFileWriter.createNew(NetcdfFileWriter.Version.netcdf4, filename);
            // dataFile = NetcdfFileWriter.createNew(NetcdfFileWriter.Version.netcdf3, filename);

            // placeholder value
            dataFile.addGroupAttribute(null, new Attribute("missing_data_value", dfs.placeholder_value));

            // number of populations
            dataFile.addGroupAttribute(null, new Attribute("number_of_populations", dfs.npops));

            // number of areas
            dataFile.addGroupAttribute(null, new Attribute("number_of_areas", dfs.nareas));

            // create dimensions
            /* netCDF4
            Dimension popDim  = dataFile.addDimension(null, "populations", 2, true, true, true);
            Dimension areaDim = dataFile.addDimension(null, "areas", 2, true, true, true);
            Dimension yearDim = dataFile.addDimension(null, "years", 20, true, true, true);
            Dimension ageDim  = dataFile.addDimension(null, "ages", 10, true, true, true);
            Dimension sexDim  = dataFile.addDimension(null, "sexes", 2, true, true, true);
            Dimension lenDim  = dataFile.addDimension(null, "lengths", 10, true, true, true);
            */

           // group list
            List<Group> popAreaGroups = new ArrayList<>();
            Group tempGroup = null;

            int gidx = 0;
            String gname = "";
            String gidx_st = "";

            Variable catchVar         = null;
            Variable catchLengthsVar  = null;
            Variable catchAgesVar     = null;
            Variable catchSizeAgeVar  = null;
            Variable surveyVar        = null;
            Variable surveyLengthsVar = null;
            Variable surveyAgesVar    = null;
            Variable surveySizeAgeVar = null;

            Group rootGroup = dataFile.addGroup(null, "");
            NetcdfFile ncf = rootGroup.getNetcdfFile();

            for (int i = 0; i < dfs.npops; ++i)
            {
                for (int j = 0; j < dfs.nareas; ++j)
                {
                    gname   = "pop_" + Integer.toString(i) + "_area_" + Integer.toString(j);
                    gidx_st = Integer.toString(gidx);

                    tempGroup = dataFile.addGroup(rootGroup, gname);
                    // tempGroup = new Group(ncf, rootGroup, gname);
                    dataFile.addGroupAttribute(tempGroup, new Attribute("pop_id", i));
                    dataFile.addGroupAttribute(tempGroup, new Attribute("area_id", j));

                    Dimension yearDim = dataFile.addDimension(tempGroup, "years", dfs.nyears);
                    Dimension seasDim = dataFile.addDimension(tempGroup, "seasons", dfs.nseas);
                    Dimension sexDim  = dataFile.addDimension(tempGroup, "sexes", dfs.nsex);
                    Dimension fshDim  = dataFile.addDimension(tempGroup, "fisheries", dfs.nfsh);

                    Dimension fshLenDim = null;
                    if (dfs.nfsh_len_bins > 1)
                    {
                        fshLenDim = dataFile.addDimension(tempGroup, "fishery_lengths", dfs.nfsh_len_bins);
                    }
                    Dimension fshAgeDim = null;
                    if (dfs.nfsh_age_bins > 1)
                    {
                        fshAgeDim = dataFile.addDimension(tempGroup, "fishery_ages", dfs.nfsh_age_bins);
                    }

                    Dimension idxDim    = null;
                    Dimension idxLenDim = null;
                    Dimension idxAgeDim = null;
                    if (dfs.nidx > 0)
                    {
                        idxDim = dataFile.addDimension(tempGroup, "indices", dfs.nidx);

                        if (dfs.nidx_len_bins > 1)
                        {
                            idxLenDim = dataFile.addDimension(tempGroup, "index_lengths", dfs.nidx_len_bins);
                        }
                        if (dfs.nidx_age_bins > 1)
                        {
                            idxAgeDim = dataFile.addDimension(tempGroup, "index_ages", dfs.nidx_age_bins);
                        }
                    }

                    System.out.println("defined dimensions");

                    // store dimensions
                    List<Dimension> primaryFshDims = new ArrayList<>();
                    primaryFshDims.add(fshDim);
                    primaryFshDims.add(yearDim);
                    primaryFshDims.add(seasDim);

                    List<Dimension> fshLengthDims = new ArrayList<>();
                    fshLengthDims.add(fshDim);
                    fshLengthDims.add(yearDim);
                    fshLengthDims.add(seasDim);
                    fshLengthDims.add(sexDim);
                    fshLengthDims.add(fshLenDim);

                    List<Dimension> fshAgeDims = new ArrayList<>();
                    fshAgeDims.add(fshDim);
                    fshAgeDims.add(yearDim);
                    fshAgeDims.add(seasDim);
                    fshAgeDims.add(sexDim);
                    fshAgeDims.add(fshAgeDim);

                    List<Dimension> primaryIdxDims = new ArrayList<>();
                    primaryIdxDims.add(idxDim);
                    primaryIdxDims.add(yearDim);
                    primaryIdxDims.add(seasDim);

                    List<Dimension> idxLengthDims = new ArrayList<>();
                    idxLengthDims.add(idxDim);
                    idxLengthDims.add(yearDim);
                    idxLengthDims.add(seasDim);
                    idxLengthDims.add(sexDim);
                    idxLengthDims.add(idxLenDim);

                    List<Dimension> idxAgeDims = new ArrayList<>();
                    idxAgeDims.add(idxDim);
                    idxAgeDims.add(yearDim);
                    idxAgeDims.add(seasDim);
                    idxAgeDims.add(sexDim);
                    idxAgeDims.add(idxAgeDim);

                    System.out.println("stored dimension sets");

                    // register netCDF variables by group
                    catchVar = dataFile.addVariable(tempGroup, "catch_biomass", DataType.FLOAT, primaryFshDims);
                    catchVar.addAttribute(new Attribute("units", "metric_tonnes"));
                    if (dfs.nfsh_len_bins > 1)
                    {
                        catchLengthsVar = dataFile.addVariable(tempGroup, "catch_proportions_at_length", DataType.FLOAT, fshLengthDims);
                        catchLengthsVar.addAttribute(new Attribute("units","proportion"));
                    }
                    if (dfs.nfsh_age_bins > 1)
                    {
                        catchAgesVar    = dataFile.addVariable(tempGroup, "catch_proportions_at_age", DataType.FLOAT, fshAgeDims);
                        catchAgesVar.addAttribute(new Attribute("units","proportion"));
                    }

                   if (dfs.nidx > 0)
                    {
                        surveyVar = dataFile.addVariable(tempGroup, "index_biomass", DataType.FLOAT, primaryIdxDims);
                        surveyVar.addAttribute(new Attribute("units", "kg"));

                        if (dfs.nidx_len_bins > 0)
                        {
                            surveyLengthsVar = dataFile.addVariable(tempGroup, "index_proportions_at_length", DataType.FLOAT, idxLengthDims);
                            surveyLengthsVar.addAttribute(new Attribute("units","proportion"));
                        }

                        if (dfs.nidx_age_bins > 0)
                        {
                            surveyAgesVar    = dataFile.addVariable(tempGroup, "index_proportions_at_age", DataType.FLOAT, idxAgeDims);
                            surveyAgesVar.addAttribute(new Attribute("units","proportion"));
                        }
                    }

                    System.out.println("registered variables");

                    popAreaGroups.add(gidx, tempGroup);

                    gidx++;
                }
            }

            dataFile.create();
            System.out.println("created dataFile structure");

            gidx = 0;
            for (int i = 0; i < dfs.npops; ++i)
            {
                for (int j = 0; j < dfs.nareas; ++j)
                {
                    gname = "pop_" + Integer.toString(i) + "_area_" + Integer.toString(j);
                    gidx_st = Integer.toString(gidx);
                    System.out.println("Starting " + gname);

                    // get netCDF variable for catch
                    // tempGroup = popAreaGroups.get(gidx);
                    // catchVar = tempGroup.findVariable("catch_biomass");
                    catchVar = dataFile.findVariable(gname + "/catch_biomass");

                    int[] catchDim = new int[]{dfs.nfsh, dfs.nyears, dfs.nseas};
                    Array catchOutput = Array.factory(DataType.FLOAT, catchDim);
                    Index3D idx_C = new Index3D(catchDim);

                     for (int k = 0; k < dfs.nfsh; ++k)
                    {
                        for (int l = 0; l < dfs.nyears; ++l)
                        {
                            for (int m = 0; m < dfs.nseas; ++m)
                            {
                                idx_C.set(k,l,m);
                                catchOutput.setFloat(idx_C, dfs.catch_array[i][j][k][l][m]);
                            }
                        }
                    }

                    System.out.println("copied catch_array values");

                    System.out.println(catchVar.getNameAndDimensions());
                    System.out.println(Arrays.toString(catchOutput.getShape()));
                    // dataFile.write(catchVar, catchOutput);
                    dataFile.write(catchVar, new int[] {0, 0, 0}, catchOutput);
                    System.out.println("wrote catchVar");

                    if (dfs.nfsh_len_bins > 1)
                    {
                        int[] calDim = new int[]{dfs.nfsh, dfs.nyears, dfs.nseas, dfs.nsex, dfs.nfsh_len_bins};
                        Array fshLengthOutput = Array.factory(DataType.FLOAT, calDim);
                        Index5D idx_cal = new Index5D(calDim);

                        for (int k = 0; k < dfs.nfsh; ++k)
                        {
                            for (int l = 0; l < dfs.nyears; ++l)
                            {
                                for (int m = 0; m < dfs.nseas; ++m)
                                {
                                    for (int n = 0; n < dfs.nsex; ++n)
                                    {
                                        for (int o = 0; o < dfs.nfsh_len_bins; ++o)
                                        {
                                            idx_cal.set(k,l,m,n,o);
                                            fshLengthOutput.setFloat(idx_cal, dfs.catch_lencomps[i][j][k][l][m][n][o]);
                                        }
                                    }
                                }
                            }
                        }

                        dataFile.write(catchLengthsVar, fshLengthOutput);
                    }

                    if (dfs.nfsh_age_bins > 1)
                    {
                        int[] caaDim = new int[]{dfs.nfsh, dfs.nyears, dfs.nseas, dfs.nsex, dfs.nfsh_age_bins};
                        Array fshAgeOutput    = Array.factory(DataType.FLOAT, caaDim);
                        Index5D idx_caa = new Index5D(caaDim);

                        for (int k = 0; k < dfs.nfsh; ++k)
                        {
                            for (int l = 0; l < dfs.nyears; ++l)
                            {
                                for (int m = 0; m < dfs.nseas; ++m)
                                {
                                    for (int n = 0; n < dfs.nsex; ++n)
                                    {
                                        for (int o = 0; o < dfs.nfsh_age_bins; ++o)
                                        {
                                            idx_caa.set(k,l,m,n,o);
                                            fshAgeOutput.setFloat(idx_caa, dfs.catch_agecomps[i][j][k][l][m][n][o]);
                                        }
                                    }
                                }
                            }
                        }

                        dataFile.write(catchAgesVar, fshAgeOutput);
                    }

                    System.out.println("finished with catch data");

                    surveyVar        = dataFile.findVariable(gname + "/index_biomass");
                    surveyLengthsVar = dataFile.findVariable(gname + "/index_proportions_at_length");
                    surveyAgesVar    = dataFile.findVariable(gname + "/index_proportions_at_age");
                    writeIndex(dfs, dataFile, i, j, surveyVar, surveyLengthsVar, surveyAgesVar);

                    gidx++;
                }
            }
        }
        catch (IOException | InvalidRangeException e)
        {
          e.printStackTrace();
        }
        finally
        {
          if (null != dataFile)
            try
            {
              dataFile.close();
            }
            catch (IOException ioe)
            {
              ioe.printStackTrace();
            }
        }
    }

    public void writeIndex(final DataFileStructure dfs, NetcdfFileWriter dataFile, final int pop_num, final int area_num,
                           Variable surveyVar, Variable surveyLengthsVar, Variable surveyAgesVar) throws Exception
    {
        if (dfs == null)
        {
            throw new Exception("DataFileStructure not initialized");
        }

        try
        {
            int i = pop_num;
            int j = area_num;

            if (dfs.nidx > 0)
            {
                System.out.println("starting index data");

                int[] indexDim = new int[]{dfs.nidx, dfs.nyears, dfs.nseas};
                Array indexOutput  = Array.factory(DataType.FLOAT, indexDim);
                Index3D idx_I   = new Index3D(indexDim);

                for (int k = 0; k < dfs.nidx; ++k)
                {
                    for (int l = 0; l < dfs.nyears; ++l)
                    {
                        for (int m = 0; m < dfs.nseas; ++m)
                        {
                            idx_I.set(k,l,m);
                            indexOutput.setFloat(idx_I, dfs.index_array[i][j][k][l][m]);
                        }
                    }
                }

                System.out.println("copied index_array values");

                dataFile.write(surveyVar, indexOutput);
                System.out.println("write surveyVar");

                if (dfs.nidx_len_bins > 1)
                {
                    int[] ialDim = new int[]{dfs.nidx, dfs.nyears, dfs.nseas, dfs.nsex, dfs.nidx_len_bins};
                    Array idxLengthOutput = Array.factory(DataType.FLOAT, ialDim);
                    Index5D idx_ial = new Index5D(ialDim);

                    for (int k = 0; k < dfs.nidx; ++k)
                    {
                        for (int l = 0; l < dfs.nyears; ++l)
                        {
                            for (int m = 0; m < dfs.nseas; ++m)
                            {
                                for (int n = 0; n < dfs.nsex; ++n)
                                {
                                    for (int o = 0; o < dfs.nidx_len_bins; ++o)
                                    {
                                        idx_ial.set(k,l,m,n,o);
                                        idxLengthOutput.setFloat(idx_ial, dfs.index_lencomps[i][j][k][l][m][n][o]);
                                    }
                                }
                            }
                        }
                    }

                    dataFile.write(surveyLengthsVar, idxLengthOutput);
                }

                if (dfs.nidx_age_bins > 1)
                {
                    int[] iaaDim = new int[]{dfs.nidx, dfs.nyears, dfs.nseas, dfs.nsex, dfs.nidx_age_bins};
                    Array idxAgeOutput    = Array.factory(DataType.FLOAT, iaaDim);
                    Index5D idx_iaa = new Index5D(iaaDim);

                    for (int k = 0; k < dfs.nidx; ++k)
                    {
                        for (int l = 0; l < dfs.nyears; ++l)
                        {
                            for (int m = 0; m < dfs.nseas; ++m)
                            {
                                for (int n = 0; n < dfs.nsex; ++n)
                                {
                                    for (int o = 0; o < dfs.nidx_age_bins; ++o)
                                    {
                                        idx_iaa.set(k,l,m,n,o);
                                        idxAgeOutput.setFloat(idx_iaa, dfs.index_agecomps[i][j][k][l][m][n][o]);
                                    }
                                }
                            }
                        }
                    }

                    dataFile.write(surveyAgesVar, idxAgeOutput);
                }
            }

            System.out.println("finished with index data");
        }
        catch (IOException | InvalidRangeException e)
        {
          e.printStackTrace();
        }
        finally
        {
          if (null != dataFile)
            try
            {
              dataFile.close();
            }
            catch (IOException ioe)
            {
              ioe.printStackTrace();
            }
        }
    }

    /*
    Nc4Chunking chunker = Nc4Chunking factory(Strategy type, int deflateLevel, boolean shuffle);
    NetcdfFileWriter.Version version = NetcdfFileWriter.Version.netcdf4;

    FileWriter2 writer = new ucar.nc2.FileWriter2(ncfileIn, filenameOut, version, chunker);
    // blar blar blar
    NetcdfFile ncfileOut = writer.write();
    ncfileIn.close();
    ncfileOut.close();
    */
}
