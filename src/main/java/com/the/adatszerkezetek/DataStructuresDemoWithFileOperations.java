/**
 * 
 */
package com.the.adatszerkezetek;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * To view the updated file in live:
 * Get-Content demo.csv –Wait
 * 
 * @author Veres Zoltán
 */
public class DataStructuresDemoWithFileOperations {
    String file_name = "demo.csv";
    
    FileOutputStream file_output_stream;
    OutputStreamWriter file_output_stream_writer;
    CSVWriter file_write_handler;
    
    FileInputStream file_input_stream;
    InputStreamReader file_input_stream_reader;
    CSVReader file_read_handler;
    
    DataStructuresDemoWithFileOperations()
    {
        try {
            this.file_output_stream = new FileOutputStream(this.file_name);
            this.file_output_stream_writer = new OutputStreamWriter(
                this.file_output_stream, 
                "UTF-8"
            );
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(
                DataStructuresDemoWithFileOperations.class.getName()
            ).log(Level.SEVERE, null, ex);
        }
    }
    
    void run()
    {
        try
        {
            String[] test_data = {"apple", "banana", "orange", "kiwi"};
            this.writeRow(test_data);

            System.out.println(Arrays.toString(this.readRow()));
            
            
        }
        catch (Exception ex)
        {
            Logger.getLogger(
                DataStructuresDemoWithFileOperations.class.getName()
            ).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                this.file_output_stream_writer.close();
                this.file_output_stream.close();
            } catch (IOException ex) {
                Logger.getLogger(
                    DataStructuresDemoWithFileOperations.class.getName()
                ).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    void writeRow(String[] row)
    {
        try
        {
            if (row == null)
            {
                try (
                    FileWriter fw = new FileWriter(this.file_name, false); 
                    PrintWriter pw = new PrintWriter(fw, false)
                ) {
                    pw.flush();
                }
                
                return;
            }
            
            this.file_write_handler = new CSVWriter(
                this.file_output_stream_writer
            );
            
            this.file_write_handler.writeNext(row);
            this.file_write_handler.close();
        }
        catch (IOException ex)
        {
            Logger.getLogger(
                DataStructuresDemoWithFileOperations.class.getName()
            ).log(Level.SEVERE, null, ex);
        }
    }
    
    String[] readRow()
    {
        String[] row = null;
        
        try
        {
            this.file_input_stream = new FileInputStream(this.file_name);
            this.file_input_stream_reader = new InputStreamReader(
                this.file_input_stream, 
                "UTF-8"
            );
            this.file_read_handler = new CSVReader(
                this.file_input_stream_reader
            );
            
            row = this.file_read_handler.readNext();
            
            this.file_read_handler.close();
            this.file_input_stream_reader.close();
            this.file_input_stream.close();
            
            //System.out.println("Removing file contents...");
            //this.writeRow(null);
        }
        catch (FileNotFoundException | UnsupportedEncodingException ex)
        {
            Logger.getLogger(
                DataStructuresDemoWithFileOperations.class.getName()
            ).log(Level.SEVERE, null, ex);
        } catch (IOException | CsvValidationException ex) {
            Logger.getLogger(
                DataStructuresDemoWithFileOperations.class.getName()
            ).log(Level.SEVERE, null, ex);
        }
        
        return row;
    }
}
