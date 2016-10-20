/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsemasinputfiles;

import java.util.Arrays;

/**
 *
 * @author amart
 */
public class DataFileStructure
{
    String datafilename = "";
    String netCDFfilename = "";

    int placeholder_value = -1;

    int npops  = -1;

    int nareas = -1;

    int start_year = 0;
    int end_year   = 0;
    int nyears     = -1;

    int nseas = -1;
    float[] seas_frac = null;

    int nsex = -1;

    int nfsh = -1;

    int nfsh_len_bins = -1;
    float[] fsh_len_bins = null;
    int nfsh_age_bins = -1;
    int[] fsh_age_bins = null;

    int nidx = -1;

    int nidx_len_bins = -1;
    float[] idx_len_bins = null;
    int nidx_age_bins = -1;
    int[] idx_age_bins = null;

    float[][][][][] catch_array = null;           // population, area, fleet, year, season
    float[][][][][][][] catch_lencomps = null;    // population, area, fleet, year, season, sex, fishery length bin
    float[][][][][][][] catch_agecomps = null;    // population, area, fleet, year, season, sex, fishery age bin

    float[][][][][] index_array = null;           // population, area, index, year, season
    float[][][][][][][] index_lencomps = null;    // population, area, index, year, season, sex, index length bin
    float[][][][][][][] index_agecomps = null;    // population, area, index, year, season, sex, index age bin

    void print()
    {
        System.out.println(String.join("data filename: ", this.datafilename));
        System.out.println(String.join("netCDF filename: ", this.netCDFfilename));
        System.out.println(String.join("placeholder value for missing data: ", Integer.toString(this.placeholder_value)));
        System.out.println(String.join("npopulations: ", Integer.toString(this.npops)));
        System.out.println(String.join("nareas: ", Integer.toString(this.nareas)));
        System.out.println(String.join("start year: ", Integer.toString(this.start_year)));
        System.out.println(String.join("end year: ", Integer.toString(this.end_year)));
        System.out.println(String.join("nyears: ", Integer.toString(this.nyears)));
        System.out.println(String.join("nseas: ", Integer.toString(this.nseas)));
        System.out.println(String.join("seas fraction: ", Arrays.toString(this.seas_frac)));
        System.out.println(String.join("nsex: ", Integer.toString(this.nsex)));
        System.out.println(String.join("nfisheries: ", Integer.toString(this.nfsh)));
        System.out.println(String.join("n fishery length bins: ", Integer.toString(this.nfsh_len_bins)));
        System.out.println(String.join("fishery length bins: ", Arrays.toString(this.fsh_len_bins)));
        System.out.println(String.join("n fisery age bins: ", Integer.toString(this.nfsh_age_bins)));
        System.out.println(String.join("fishery age bins: ", Arrays.toString(this.fsh_age_bins)));
        System.out.println(String.join("nindices: ", Integer.toString(this.nidx)));
        System.out.println(String.join("n index length bins: ", Integer.toString(this.nidx_len_bins)));
        System.out.println(String.join("index length bins: ", Arrays.toString(this.idx_len_bins)));
        System.out.println(String.join("n index age bins: ", Integer.toString(this.nidx_age_bins)));
        System.out.println(String.join("index age bins: ", Arrays.toString(this.idx_age_bins)));

        System.out.println(String.join("catch: ", Arrays.deepToString(this.catch_array)));
        System.out.println(String.join("catch length comps: ", Arrays.deepToString(this.catch_lencomps)));
        System.out.println(String.join("catch age comps: ", Arrays.deepToString(this.catch_agecomps)));
        System.out.println(String.join("indices: ", Arrays.deepToString(this.index_array)));
        System.out.println(String.join("index length comps: ", Arrays.deepToString(this.index_lencomps)));
        System.out.println(String.join("index age comps: ", Arrays.deepToString(this.index_agecomps)));
    }
}
