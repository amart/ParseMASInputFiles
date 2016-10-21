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
    String filename = "inputdata.nc4";
    NetcdfFileWriter dataFile = null;

    public void write(DataFileStructure dfs, final String s) throws Exception
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

            Variable catchVar          = null;
            Variable catchLengthsNVar  = null;
            Variable catchLengthsVar   = null;
            Variable catchAgesNVar     = null;
            Variable catchAgesVar      = null;
            Variable catchSizeAgeVar   = null;
            Variable surveyVar         = null;
            Variable surveyLengthsNVar = null;
            Variable surveyLengthsVar  = null;
            Variable surveyAgesNVar    = null;
            Variable surveyAgesVar     = null;
            Variable surveySizeAgeVar  = null;

            Group rootGroup = dataFile.addGroup(null, "");
            NetcdfFile ncf = rootGroup.getNetcdfFile();

            Dimension fshDim     = dataFile.addDimension(rootGroup, "fisheries", dfs.nfsh);
            Dimension fshYearDim = dataFile.addDimension(rootGroup, "fishery_years", dfs.nyears);
            Dimension fshSeasDim = dataFile.addDimension(rootGroup, "fishery_seasons", dfs.nseas);
            Dimension fshSexDim  = dataFile.addDimension(rootGroup, "fishery_sexes", dfs.nsex);

            Dimension fshLenDim = null;
            if (dfs.nfsh_len_bins > 1)
            {
                fshLenDim = dataFile.addDimension(rootGroup, "fishery_lengths", dfs.nfsh_len_bins);
            }
            Dimension fshAgeDim = null;
            if (dfs.nfsh_age_bins > 1)
            {
                fshAgeDim = dataFile.addDimension(rootGroup, "fishery_ages", dfs.nfsh_age_bins);
            }

            Dimension idxDim     = null;
            Dimension idxYearDim = null;
            Dimension idxLenDim  = null;
            Dimension idxAgeDim  = null;
            if (dfs.nidx > 0)
            {
                idxDim     = dataFile.addDimension(rootGroup, "indices", dfs.nidx);

                // NOTE:  these values could be different than the fishery values
                idxYearDim = dataFile.addDimension(rootGroup, "index_years", dfs.nyears);
                idxLenDim  = dataFile.addDimension(rootGroup, "index_seasons", dfs.nseas);
                idxAgeDim  = dataFile.addDimension(rootGroup, "index_sexes", dfs.nsex);

                if (dfs.nidx_len_bins > 1)
                {
                    idxLenDim = dataFile.addDimension(rootGroup, "index_lengths", dfs.nidx_len_bins);
                }
                if (dfs.nidx_age_bins > 1)
                {
                    idxAgeDim = dataFile.addDimension(rootGroup, "index_ages", dfs.nidx_age_bins);
                }
            }

            System.out.println("defined dimensions");

            for (int i = 0; i < dfs.npops; ++i)
            {
                for (int j = 0; j < dfs.nareas; ++j)
                {
                    gname   = "pop_" + Integer.toString(i) + "_area_" + Integer.toString(j);

                    tempGroup = dataFile.addGroup(rootGroup, gname);
                    // tempGroup = new Group(ncf, rootGroup, gname);
                    dataFile.addGroupAttribute(tempGroup, new Attribute("pop_id", i));
                    dataFile.addGroupAttribute(tempGroup, new Attribute("area_id", j));

                    // register netCDF variables by group
                    // catchVar = dataFile.addVariable(tempGroup, "catch_biomass", DataType.FLOAT, primaryFshDims);
                    catchVar = dataFile.addVariable(tempGroup, "catch_biomass", DataType.FLOAT, "fisheries fishery_years fishery_seasons");
                    catchVar.addAttribute(new Attribute("units", "metric_tonnes"));
                    if (dfs.nfsh_len_bins > 1)
                    {
                        catchLengthsNVar = dataFile.addVariable(tempGroup, "catch_proportions_at_length_sample_size", DataType.FLOAT, "fisheries fishery_years fishery_seasons fishery_sexes");
                        catchLengthsNVar.addAttribute(new Attribute("units","number"));

                        catchLengthsVar = dataFile.addVariable(tempGroup, "catch_proportions_at_length", DataType.FLOAT, "fisheries fishery_years fishery_seasons fishery_sexes fishery_lengths");
                        catchLengthsVar.addAttribute(new Attribute("units","proportion"));
                    }
                    if (dfs.nfsh_age_bins > 1)
                    {
                        catchAgesNVar    = dataFile.addVariable(tempGroup, "catch_proportions_at_age_sample_size", DataType.FLOAT, "fisheries fishery_years fishery_seasons fishery_sexes");
                        catchAgesNVar.addAttribute(new Attribute("units","number"));

                        catchAgesVar    = dataFile.addVariable(tempGroup, "catch_proportions_at_age", DataType.FLOAT, "fisheries fishery_years fishery_seasons fishery_sexes fishery_ages");
                        catchAgesVar.addAttribute(new Attribute("units","proportion"));
                    }

                   if (dfs.nidx > 0)
                    {
                        surveyVar = dataFile.addVariable(tempGroup, "index_biomass", DataType.FLOAT, "indices index_years index_seasons");
                        surveyVar.addAttribute(new Attribute("units", "kg"));

                        if (dfs.nidx_len_bins > 0)
                        {
                            surveyLengthsNVar = dataFile.addVariable(tempGroup, "index_proportions_at_length_sample_size", DataType.FLOAT, "indices index_years index_seasons index_sexes");
                            surveyLengthsNVar.addAttribute(new Attribute("units","number"));

                            surveyLengthsVar = dataFile.addVariable(tempGroup, "index_proportions_at_length", DataType.FLOAT, "indices index_years index_seasons index_sexes index_lengths");
                            surveyLengthsVar.addAttribute(new Attribute("units","proportion"));
                        }

                        if (dfs.nidx_age_bins > 0)
                        {
                            surveyAgesNVar    = dataFile.addVariable(tempGroup, "index_proportions_at_age_sample_size", DataType.FLOAT, "indices index_years index_seasons index_sexes");
                            surveyAgesNVar.addAttribute(new Attribute("units","number"));

                            surveyAgesVar    = dataFile.addVariable(tempGroup, "index_proportions_at_age", DataType.FLOAT, "indices index_years index_seasons index_sexes index_ages");
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
                    System.out.println("Starting " + gname);

                    catchVar          = dataFile.findVariable(gname + "/catch_biomass");
                    catchLengthsNVar  = dataFile.findVariable(gname + "/catch_proportions_at_length_sample_size");
                    catchLengthsVar   = dataFile.findVariable(gname + "/catch_proportions_at_length");
                    catchAgesNVar     = dataFile.findVariable(gname + "/catch_proportions_at_age_sample_size");
                    catchAgesVar      = dataFile.findVariable(gname + "/catch_proportions_at_age");
                    writeCatch(dfs, dataFile, i, j, catchVar, catchLengthsNVar, catchLengthsVar, catchAgesNVar, catchAgesVar);

                    surveyVar         = dataFile.findVariable(gname + "/index_biomass");
                    surveyLengthsNVar = dataFile.findVariable(gname + "/index_proportions_at_length_sample_size");
                    surveyLengthsVar  = dataFile.findVariable(gname + "/index_proportions_at_length");
                    surveyAgesNVar    = dataFile.findVariable(gname + "/index_proportions_at_age_sample_size");
                    surveyAgesVar     = dataFile.findVariable(gname + "/index_proportions_at_age");
                    writeIndex(dfs, dataFile, i, j, surveyVar, surveyLengthsNVar, surveyLengthsVar, surveyAgesNVar, surveyAgesVar);

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

    public void writeCatch(final DataFileStructure dfs, NetcdfFileWriter dataFile, final int pop_num, final int area_num,
                           Variable catchVar, Variable catchLengthsNVar, Variable catchLengthsVar, Variable catchAgesNVar, Variable catchAgesVar) throws Exception
    {
        if (null == dfs)
        {
            throw new Exception("DataFileStructure not initialized");
        }

        if (null == dataFile)
        {
            throw new Exception("NetcdfFileWriter not initialized");
        }

        try
        {
            int i = pop_num;
            int j = area_num;

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

            dataFile.write(catchVar, catchOutput);
            System.out.println("wrote catchVar");

            if (dfs.nfsh_len_bins > 1)
            {
                int[] calDim4 = new int[]{dfs.nfsh, dfs.nyears, dfs.nseas, dfs.nsex};
                Array fshLengthNOutput = Array.factory(DataType.FLOAT, calDim4);
                Index4D idx_cal_4 = new Index4D(calDim4);

                int[] calDim5 = new int[]{dfs.nfsh, dfs.nyears, dfs.nseas, dfs.nsex, dfs.nfsh_len_bins};
                Array fshLengthOutput = Array.factory(DataType.FLOAT, calDim5);
                Index5D idx_cal_5 = new Index5D(calDim5);

                for (int k = 0; k < dfs.nfsh; ++k)
                {
                    for (int l = 0; l < dfs.nyears; ++l)
                    {
                        for (int m = 0; m < dfs.nseas; ++m)
                        {
                            for (int n = 0; n < dfs.nsex; ++n)
                            {
                                idx_cal_4.set(k,l,m,n);
                                fshLengthNOutput.setFloat(idx_cal_4, dfs.catch_lencomps_N[i][j][k][l][m][n]);

                                for (int o = 0; o < dfs.nfsh_len_bins; ++o)
                                {
                                    idx_cal_5.set(k,l,m,n,o);
                                    fshLengthOutput.setFloat(idx_cal_5, dfs.catch_lencomps[i][j][k][l][m][n][o]);
                                }
                            }
                        }
                    }
                }

                System.out.println("copied catch_lencomps values");

                dataFile.write(catchLengthsNVar, fshLengthNOutput);
                dataFile.write(catchLengthsVar, fshLengthOutput);
                System.out.println("wrote catchLengthsVar");
            }

            if (dfs.nfsh_age_bins > 1)
            {
                int[] caaDim4 = new int[]{dfs.nfsh, dfs.nyears, dfs.nseas, dfs.nsex};
                Array fshAgeNOutput    = Array.factory(DataType.FLOAT, caaDim4);
                Index4D idx_caa_4 = new Index4D(caaDim4);

                int[] caaDim5 = new int[]{dfs.nfsh, dfs.nyears, dfs.nseas, dfs.nsex, dfs.nfsh_age_bins};
                Array fshAgeOutput    = Array.factory(DataType.FLOAT, caaDim5);
                Index5D idx_caa_5 = new Index5D(caaDim5);

                for (int k = 0; k < dfs.nfsh; ++k)
                {
                    for (int l = 0; l < dfs.nyears; ++l)
                    {
                        for (int m = 0; m < dfs.nseas; ++m)
                        {
                            for (int n = 0; n < dfs.nsex; ++n)
                            {
                                idx_caa_4.set(k,l,m,n);
                                fshAgeNOutput.setFloat(idx_caa_4, dfs.catch_agecomps_N[i][j][k][l][m][n]);

                                for (int o = 0; o < dfs.nfsh_age_bins; ++o)
                                {
                                    idx_caa_5.set(k,l,m,n,o);
                                    fshAgeOutput.setFloat(idx_caa_5, dfs.catch_agecomps[i][j][k][l][m][n][o]);
                                }
                            }
                        }
                    }
                }

                System.out.println("copied catch_agecomps values");

                dataFile.write(catchAgesNVar, fshAgeNOutput);
                dataFile.write(catchAgesVar, fshAgeOutput);
                System.out.println("wrote catchAgesVar");
            }

            System.out.println("finished with catch data");
        }
        catch (IOException | InvalidRangeException e)
        {
          e.printStackTrace();
        }
    }

    public void writeIndex(final DataFileStructure dfs, NetcdfFileWriter dataFile, final int pop_num, final int area_num,
                           Variable surveyVar, Variable surveyLengthsNVar, Variable surveyLengthsVar, Variable surveyAgesNVar, Variable surveyAgesVar) throws Exception
    {
        if (null == dfs)
        {
            throw new Exception("DataFileStructure not initialized");
        }

        if (null == dataFile)
        {
            throw new Exception("NetcdfFileWriter not initialized");
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

                // System.out.println(surveyVar.getNameAndDimensions());
                // System.out.println(Arrays.toString(indexOutput.getShape()));
                dataFile.write(surveyVar, indexOutput);
                System.out.println("wrote indexVar");

                if (dfs.nidx_len_bins > 1)
                {
                    int[] ialDim4 = new int[]{dfs.nidx, dfs.nyears, dfs.nseas, dfs.nsex};
                    Array idxLengthNOutput = Array.factory(DataType.FLOAT, ialDim4);
                    Index4D idx_ial_4 = new Index4D(ialDim4);

                    int[] ialDim5 = new int[]{dfs.nidx, dfs.nyears, dfs.nseas, dfs.nsex, dfs.nidx_len_bins};
                    Array idxLengthOutput = Array.factory(DataType.FLOAT, ialDim5);
                    Index5D idx_ial_5 = new Index5D(ialDim5);

                    for (int k = 0; k < dfs.nidx; ++k)
                    {
                        for (int l = 0; l < dfs.nyears; ++l)
                        {
                            for (int m = 0; m < dfs.nseas; ++m)
                            {
                                for (int n = 0; n < dfs.nsex; ++n)
                                {
                                    idx_ial_4.set(k,l,m,n);
                                    idxLengthNOutput.setFloat(idx_ial_4, dfs.index_lencomps_N[i][j][k][l][m][n]);

                                    for (int o = 0; o < dfs.nidx_len_bins; ++o)
                                    {
                                        idx_ial_5.set(k,l,m,n,o);
                                        idxLengthOutput.setFloat(idx_ial_5, dfs.index_lencomps[i][j][k][l][m][n][o]);
                                    }
                                }
                            }
                        }
                    }

                    System.out.println("copied index_lencomps values");

                    dataFile.write(surveyLengthsNVar, idxLengthNOutput);
                    dataFile.write(surveyLengthsVar, idxLengthOutput);
                    System.out.println("wrote indexLengthsVar");
                }

                if (dfs.nidx_age_bins > 1)
                {
                    int[] iaaDim4 = new int[]{dfs.nidx, dfs.nyears, dfs.nseas, dfs.nsex};
                    Array idxAgeNOutput    = Array.factory(DataType.FLOAT, iaaDim4);
                    Index4D idx_iaa_4 = new Index4D(iaaDim4);

                    int[] iaaDim5 = new int[]{dfs.nidx, dfs.nyears, dfs.nseas, dfs.nsex, dfs.nidx_age_bins};
                    Array idxAgeOutput    = Array.factory(DataType.FLOAT, iaaDim5);
                    Index5D idx_iaa_5 = new Index5D(iaaDim5);

                    for (int k = 0; k < dfs.nidx; ++k)
                    {
                        for (int l = 0; l < dfs.nyears; ++l)
                        {
                            for (int m = 0; m < dfs.nseas; ++m)
                            {
                                for (int n = 0; n < dfs.nsex; ++n)
                                {
                                    idx_iaa_4.set(k,l,m,n);
                                    idxAgeNOutput.setFloat(idx_iaa_4, dfs.index_agecomps_N[i][j][k][l][m][n]);

                                    for (int o = 0; o < dfs.nidx_age_bins; ++o)
                                    {
                                        idx_iaa_5.set(k,l,m,n,o);
                                        idxAgeOutput.setFloat(idx_iaa_5, dfs.index_agecomps[i][j][k][l][m][n][o]);
                                    }
                                }
                            }
                        }
                    }

                    System.out.println("copied index_agecomps values");

                    dataFile.write(surveyAgesNVar, idxAgeNOutput);
                    dataFile.write(surveyAgesVar, idxAgeOutput);
                    System.out.println("wrote indexAgesVar");
                }
            }

            System.out.println("finished with index data");
        }
        catch (IOException | InvalidRangeException e)
        {
          e.printStackTrace();
        }
    }
}
