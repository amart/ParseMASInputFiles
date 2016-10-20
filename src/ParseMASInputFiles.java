/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsemasinputfiles;

/**
 *
 * @author amart
 */
public class ParseMASInputFiles
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // if (args.length > 1)
        // {
            try
            {
                // ParseDataInputFile pdif    = new ParseDataInputFile(args[1]);
                ParseDataInputFile pdif    = new ParseDataInputFile("MAS_input_file.txt");
                WritenetCDFOutputFile wnof = new WritenetCDFOutputFile();
                DataFileStructure dfs      = new DataFileStructure();

                if (pdif.read(dfs))
                {
                    System.out.println("Input file read");

                    // success
                    wnof.write(dfs,"MAS_input_data.nc4");
                    System.out.println("netCDF file written");
                } else
                {
                    // nope
                    System.out.println("Input file not read");
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    // }
}
