/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsemasinputfiles;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author amart
 */
public class ParseDataInputFile
{
    String filename = null;

    ParseDataInputFile(String s) throws Exception
    {
        if (!s.isEmpty())
        {
            filename = s;
        }
        else
        {
            // throw an exception
            throw new IOException("no input filename specified");
        }
    }

    boolean read(DataFileStructure dfs) throws Exception
    {
        boolean goodRead = false;

        dfs.datafilename = filename;

        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String line;

            line = readLines_skip_blanks_and_hashes(br);

                    // placeholder value for missing data READ
            dfs.placeholder_value = Integer.parseInt(line);
            if (dfs.npops >= 0)
            {
                throw new Exception("placeholder value for missing data must be less than 0");
            }

            line = readLines_skip_blanks_and_hashes(br);

            // number of populations READ
            dfs.npops = Integer.parseInt(line);
            if (dfs.npops < 1)
            {
                throw new Exception("invalid number of populations");
            }

            line = readLines_skip_blanks_and_hashes(br);

            // number of areas READ
            dfs.nareas = Integer.parseInt(line);
            if (dfs.nareas < 1)
            {
                throw new Exception("invalid number of areas");
            }

            line = readLines_skip_blanks_and_hashes(br);

            // start year and end year READ
            String[] split_line = line.split("\\s+");
            dfs.start_year = Integer.parseInt(split_line[0]);
            dfs.end_year   = Integer.parseInt(split_line[1]);
            dfs.nyears     = dfs.end_year - dfs.start_year + 1;
            if (dfs.nyears < 1 || dfs.start_year > dfs.end_year)
            {
                throw new Exception("start year and end year mismatch");
            }

            line = readLines_skip_blanks_and_hashes(br);

            // number of seasons READ, seasonal fractions READ if number of seasons > 1
            split_line = line.split("\\s+");
            dfs.nseas = Integer.parseInt(split_line[0]);
            if (dfs.nseas < 1)
            {
                throw new Exception("invalid number of seasons");
            }
            else if (dfs.nseas > 1)
            {
                int nfracs = split_line.length - 1;
                if (dfs.nseas != nfracs)
                {
                    throw new Exception("season fraction mismatch");
                }
                dfs.seas_frac = new float[nfracs];
                for (int i = 0; i < nfracs; ++i)
                {
                    dfs.seas_frac[i] = Float.parseFloat(split_line[i+1]);
                }
            }

            line = readLines_skip_blanks_and_hashes(br);

            // number of data sexes READ
            dfs.nsex = Integer.parseInt(line);
            if (dfs.nsex < 1 || dfs.nsex > 2)
            {
                throw new Exception("invalid number of sexes");
            }

            line = readLines_skip_blanks_and_hashes(br);

            // number of data fisheries READ
            dfs.nfsh = Integer.parseInt(line);
            if (dfs.nfsh < 1)
            {
                throw new Exception("invalid number of fisheries");
            }

            line = readLines_skip_blanks_and_hashes(br);

            // number of data fishery length bins READ, length bin values READ
            split_line = line.split("\\s+");
            dfs.nfsh_len_bins = Integer.parseInt(split_line[0]);
            if (dfs.nfsh_len_bins < 2)
            {
                if (dfs.nfsh_len_bins == 0)
                {
                    // no length comp data, so skip
                }
                else
                {
                    throw new Exception("invalid number of fishery length bins");
                }
            }
            else
            {
                dfs.fsh_len_bins = new float[dfs.nfsh_len_bins];
                for (int i = 0; i < dfs.nfsh_len_bins; ++i)
                {
                    dfs.fsh_len_bins[i] = Float.parseFloat(split_line[i+1]);
                }
            }

            line = readLines_skip_blanks_and_hashes(br);

            // number of data fishery age bins READ, age bin values READ
            split_line = line.split("\\s+");
            dfs.nfsh_age_bins = Integer.parseInt(split_line[0]);
            if (dfs.nfsh_age_bins < 2)
            {
                if (dfs.nfsh_age_bins == 0)
                {
                    // no age comp data, so skip
                }
                else
                {
                    throw new Exception("invalid number of fishery age bins");
                }
            }
            else
            {
                dfs.fsh_age_bins = new int[dfs.nfsh_age_bins];
                for (int i = 0; i < dfs.nfsh_age_bins; ++i)
                {
                    dfs.fsh_age_bins[i] = Integer.parseInt(split_line[i+1]);
                }
            }

            line = readLines_skip_blanks_and_hashes(br);

            // number of data indices READ
            dfs.nidx = Integer.parseInt(line);
            if (dfs.nidx < 0)
            {
                throw new Exception("invalid number of indices");
            }

            line = readLines_skip_blanks_and_hashes(br);

            // number of data index length bins READ, length bin values READ
            split_line = line.split("\\s+");
            dfs.nidx_len_bins = Integer.parseInt(split_line[0]);
            if (dfs.nidx_len_bins < 2)
            {
                if (dfs.nidx_len_bins == 0)
                {
                    // no length comp data, so skip
                }
                else
                {
                    throw new Exception("invalid number of index length bins");
                }
            }
            else if (dfs.nidx > 0)
            {
                dfs.idx_len_bins = new float[dfs.nidx_len_bins];
                for (int i = 0; i < dfs.nidx_len_bins; ++i)
                {
                    dfs.idx_len_bins[i] = Float.parseFloat(split_line[i+1]);
                }
            }

            line = readLines_skip_blanks_and_hashes(br);

            // number of data index age bins READ, age bin values READ
            split_line = line.split("\\s+");
            dfs.nidx_age_bins = Integer.parseInt(split_line[0]);
            if (dfs.nidx_age_bins < 2)
            {
                if (dfs.nidx_age_bins == 0)
                {
                    // no age comp data, so skip
                }
                else
                {
                    throw new Exception("invalid number of index age bins");
                }
            }
            else
            {
                dfs.idx_age_bins = new int[dfs.nidx_age_bins];
                for (int i = 0; i < dfs.nidx_age_bins; ++i)
                {
                    dfs.idx_age_bins[i] = Integer.parseInt(split_line[i+1]);
                }
            }


            // other stuff...

            line = readLines_skip_blanks_and_hashes(br);

            // NOTE:  seasons ARE NOT USED for the following arrays

            // catch vectors READ, by population, area, year, season
            split_line = line.split("\\s+");
            dfs.catch_array = new float[dfs.npops][dfs.nareas][dfs.nfsh][dfs.nyears][dfs.nseas];
            int idx = 0;
            for (int i = 0; i < dfs.npops; ++i)
            {
                for (int j = 0; j < dfs.nareas; ++j)
                {
                    for (int k = 0; k < dfs.nfsh; ++k)
                    {
                        for (int l = 0; l < dfs.nyears; ++l)
                        {
                            // for (int l = 0; l < dfs.nseas; ++l)
                            // {
                                // dfs.catch_array[i][j][k][l] = Float.parseFloat(split_line[idx]);
                                dfs.catch_array[i][j][k][l][0] = Float.parseFloat(split_line[idx]);
                                idx++;
                            // }
                        }
                    }

                    line = br.readLine();   // read blank line
                    line = br.readLine();
                    split_line = line.split("\\s+");
                    idx = 0;
                }
            }

            // catch length composition vectors READ, by population, area, year, season, sex, fishery length bin
            if (dfs.nfsh_len_bins > 1)
            {
                line = readLines_skip_blanks_and_hashes(br);

                split_line = line.split("\\s+");
                dfs.catch_lencomps = new float[dfs.npops][dfs.nareas][dfs.nfsh][dfs.nyears][dfs.nseas][dfs.nsex][dfs.nfsh_len_bins];
                idx = 0;
                for (int i = 0; i < dfs.npops; ++i)
                {
                    for (int j = 0; j < dfs.nareas; ++j)
                    {
                        for (int k = 0; k < dfs.nfsh; ++k)
                        {
                            for (int o = 0; o < dfs.nfsh_len_bins; ++o)
                            {
                                for (int l = 0; l < dfs.nyears; ++l)
                                {
                                    // dfs.catch_array[i][j][k][l] = Float.parseFloat(split_line[idx]);
                                    dfs.catch_lencomps[i][j][k][l][0][0][o] = Float.parseFloat(split_line[idx]);
                                    idx++;
                                }
                            }
                        }

                        line = br.readLine();   // read blank line
                        line = br.readLine();
                        split_line = line.split("\\s+");
                        idx = 0;
                    }
                }
            }

            // catch age composition vectors READ, by population, area, year, season, fishery age bin
            if (dfs.nfsh_age_bins > 1)
            {
                line = readLines_skip_blanks_and_hashes(br);

                split_line = line.split("\\s+");
                dfs.catch_agecomps = new float[dfs.npops][dfs.nareas][dfs.nfsh][dfs.nyears][dfs.nseas][dfs.nsex][dfs.nfsh_age_bins];
                idx = 0;
                for (int i = 0; i < dfs.npops; ++i)
                {
                    for (int j = 0; j < dfs.nareas; ++j)
                    {
                        for (int k = 0; k < dfs.nfsh; ++k)
                        {
                            for (int o = 0; o < dfs.nfsh_age_bins; ++o)
                            {
                                for (int l = 0; l < dfs.nyears; ++l)
                                {
                                    // dfs.catch_agecomps[i][j][k][l][m][n][o] = Float.parseFloat(split_line[idx]);
                                    dfs.catch_agecomps[i][j][k][l][0][0][o] = Float.parseFloat(split_line[idx]);
                                    idx++;
                                }

                                line = br.readLine();
                                if (!line.isEmpty())
                                {
                                    split_line = line.split("\\s+");
                                }
                                idx = 0;
                            }
                        }

                        if (dfs.nfsh > 1)
                        {
                            line = br.readLine();   // read blank line
                            line = br.readLine();
                            split_line = line.split("\\s+");
                            idx = 0;
                        }
                    }

                    if (dfs.nareas > 1)
                    {
                        line = br.readLine();   // read blank line
                        line = br.readLine();
                        split_line = line.split("\\s+");
                        idx = 0;
                    }
                }

                if (dfs.npops > 1)
                {
                    line = br.readLine();   // read blank line
                    line = br.readLine();
                    split_line = line.split("\\s+");
                    idx = 0;
                }
            }

            if (dfs.nidx > 0)
            {
                line = readLines_skip_blanks_and_hashes(br);

                // index vectors READ, by population, area, year, season
                split_line = line.split("\\s+");
                dfs.index_array = new float[dfs.npops][dfs.nareas][dfs.nidx][dfs.nyears][dfs.nseas];
                idx = 0;
                for (int i = 0; i < dfs.npops; ++i)
                {
                    for (int j = 0; j < dfs.nareas; ++j)
                    {
                        for (int k = 0; k < dfs.nidx; ++k)
                        {
                            for (int l = 0; l < dfs.nyears; ++l)
                            {
                                // dfs.catch_array[i][j][k][l] = Float.parseFloat(split_line[idx]);
                                dfs.index_array[i][j][k][l][0] = Float.parseFloat(split_line[idx]);
                                idx++;
                            }
                        }

                        line = br.readLine();   // read blank line
                        line = br.readLine();
                        split_line = line.split("\\s+");
                        idx = 0;
                    }
                }


                // index length composition vectors READ, by population, area, index, year, season, sex, index length bin
                if (dfs.nidx_len_bins > 1)
                {
                    line = readLines_skip_blanks_and_hashes(br);

                    split_line = line.split("\\s+");
                    dfs.index_lencomps = new float[dfs.npops][dfs.nareas][dfs.nidx][dfs.nyears][dfs.nseas][dfs.nsex][dfs.nidx_len_bins];
                    idx = 0;
                    for (int i = 0; i < dfs.npops; ++i)
                    {
                        for (int j = 0; j < dfs.nareas; ++j)
                        {
                            for (int k = 0; k < dfs.nidx; ++k)
                            {
                                for (int o = 0; o < dfs.nidx_len_bins; ++o)
                                {
                                    for (int l = 0; l < dfs.nyears; ++l)
                                    {
                                        // dfs.catch_array[i][j][k][l] = Float.parseFloat(split_line[idx]);
                                        dfs.index_lencomps[i][j][k][l][0][0][o] = Float.parseFloat(split_line[idx]);
                                        idx++;
                                    }
                                }
                            }

                            line = br.readLine();   // read blank line
                            line = br.readLine();
                            split_line = line.split("\\s+");
                            idx = 0;
                        }
                    }
                }

                // index age composition vectors READ, by population, area, index, year, season, index age bin
                if (dfs.nidx_age_bins > 1)
                {
                    line = readLines_skip_blanks_and_hashes(br);

                    split_line = line.split("\\s+");
                    dfs.index_agecomps = new float[dfs.npops][dfs.nareas][dfs.nidx][dfs.nyears][dfs.nseas][dfs.nsex][dfs.nidx_age_bins];
                    idx = 0;
                    for (int i = 0; i < dfs.npops; ++i)
                    {
                        for (int j = 0; j < dfs.nareas; ++j)
                        {
                            for (int k = 0; k < dfs.nidx; ++k)
                            {
                                for (int o = 0; o < dfs.nidx_age_bins; ++o)
                                {
                                    for (int l = 0; l < dfs.nyears; ++l)
                                    {
                                        // dfs.catch_agecomps[i][j][k][l][m][n][o] = Float.parseFloat(split_line[idx]);
                                        dfs.index_agecomps[i][j][k][l][0][0][o] = Float.parseFloat(split_line[idx]);
                                        idx++;
                                    }

                                    line = br.readLine();
                                    if (!line.isEmpty())
                                    {
                                        split_line = line.split("\\s+");
                                    }
                                    idx = 0;
                                }
                            }

                            if (dfs.nidx > 1)
                            {
                                line = br.readLine();   // read blank line
                                line = br.readLine();
                                split_line = line.split("\\s+");
                                idx = 0;
                            }
                        }

                        if (dfs.nareas > 1)
                        {
                            line = br.readLine();   // read blank line
                            line = br.readLine();
                            split_line = line.split("\\s+");
                            idx = 0;
                        }
                    }

                    if (dfs.npops > 1)
                    {
                        line = br.readLine();   // read blank line
                        line = br.readLine();
                        split_line = line.split("\\s+");
                        idx = 0;
                    }
                }
            }

            goodRead = true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return goodRead;
    }

    String readLines_skip_blanks_and_hashes(BufferedReader br)
    {
        String line = "";

        try
        {
            while ((line = br.readLine()) != null)
            {
                // skip comments and blank lines and get to the next line with numbers
                if (!(line.startsWith("#") || line.isEmpty()))
                    break;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return line;
    }
}
