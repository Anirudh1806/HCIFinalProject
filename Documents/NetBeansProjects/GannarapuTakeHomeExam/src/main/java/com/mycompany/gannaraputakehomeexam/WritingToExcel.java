/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gannaraputakehomeexam;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author S525717
 */
public class WritingToExcel {
 /*
    specifying the input file path
*/
    private static final String FILE_PATH = "C:/Gannarapu_Output.xlsx";
    


/*
    We are making use of a single instance to prevent multiple write access to same file.
    */
    private static final WritingToExcel INSTANCE = new WritingToExcel();

    public static WritingToExcel getInstance() {
        return INSTANCE;
    }

 /**
 * No ArgsContructor with no body defined
 */
   
    public WritingToExcel() {
    }


    
/*
    create a method to write data to excel file
    */
    public  void writeSongsToExcel(List<SongsList> songList){

        
        /*
        Use XSSF for xlsx format and for xls use HSSF
        */
        Workbook workbook = new XSSFWorkbook();
        
        
        /*
        create new sheet 
        */
        Sheet songsSheet = workbook.createSheet("Gannarapu_Output");
        
        XSSFCellStyle my_style = (XSSFCellStyle) workbook.createCellStyle();     
        /* Create XSSFFont object from the workbook */
        XSSFFont my_font=(XSSFFont) workbook.createFont();
        XSSFFont font=(XSSFFont) workbook.createFont();
        
        
        /*
        setting cell color
        */
        CellStyle style = workbook.createCellStyle();
	style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
	style.setFillPattern(CellStyle.SOLID_FOREGROUND);
            
        
        /*
         setting Header color
        */
        CellStyle style2 = workbook.createCellStyle();
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        style2.setFont(font);
        style2.setAlignment(CellStyle.ALIGN_CENTER);
//	style2.setFillForegroundColor(IndexedColors.DARK_RED.getIndex());
//	style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
//            
        
        Row rowName = songsSheet.createRow(1);
        
        /*
        Merging the cells
        */
        songsSheet.addMergedRegion(new CellRangeAddress(1, 1, 2,3 ));
      
        
        /*
        Applying style to attribute name
        */
        int nameCellIndex = 1;
        Cell namecell =  rowName.createCell(nameCellIndex++);
        namecell.setCellValue("Name");
        namecell.setCellStyle(style);
       
       
        Cell cel = rowName.createCell(nameCellIndex++);
        cel.setCellValue("Gannarapu, Anirudh");
       
       
       /*
       Applying underline to Name
       */
        my_font.setUnderline(XSSFFont.U_DOUBLE);
        my_style.setFont(my_font);
        /* Attaching the style to the cell */
        CellStyle combined = workbook.createCellStyle();
        combined.cloneStyleFrom(my_style);
        combined.cloneStyleFrom(style);
        cel.setCellStyle(combined);
 
        
        /*
        Applying  colors to header 
        */

        Row rowMain = songsSheet.createRow(3);
        SheetConditionalFormatting sheetCF = songsSheet.getSheetConditionalFormatting();
        ConditionalFormattingRule rule1 = sheetCF.createConditionalFormattingRule("5");
        PatternFormatting fill1 = rule1.createPatternFormatting();
        fill1.setFillBackgroundColor(IndexedColors.RED.index);
        fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

        CellRangeAddress[] regions = {
                CellRangeAddress.valueOf("A4:F4")
        };
       

        sheetCF.addConditionalFormatting(regions, rule1);
        
        
        /*
        setting new rule to apply alternate colors to cells having same Genre
        */
        ConditionalFormattingRule rule2 = sheetCF.createConditionalFormattingRule("4");
        PatternFormatting fill2 = rule2.createPatternFormatting();
        fill2.setFillBackgroundColor(IndexedColors.LEMON_CHIFFON.index);
        fill2.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

         CellRangeAddress[] regionsAction = {
            CellRangeAddress.valueOf("A5:F5"),
            CellRangeAddress.valueOf("A6:F6"),
            CellRangeAddress.valueOf("A7:F7"),
            CellRangeAddress.valueOf("A8:F8"),
            CellRangeAddress.valueOf("A13:F13"),
            CellRangeAddress.valueOf("A14:F14"),
            CellRangeAddress.valueOf("A15:F15"),
            CellRangeAddress.valueOf("A16:F16"),
            CellRangeAddress.valueOf("A23:F23"),
            CellRangeAddress.valueOf("A24:F24"),
            CellRangeAddress.valueOf("A25:F25"),
            CellRangeAddress.valueOf("A26:F26")
                
        };
         
         
        /*        
        setting new rule to apply alternate colors to cells having same Genre
         */
        ConditionalFormattingRule rule3 = sheetCF.createConditionalFormattingRule("4");
        PatternFormatting fill3 = rule3.createPatternFormatting();
        fill3.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.index);
        fill3.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

         CellRangeAddress[] regionsAdv = {
             CellRangeAddress.valueOf("A9:F9"),
             CellRangeAddress.valueOf("A10:F10"),
             CellRangeAddress.valueOf("A11:F11"),
             CellRangeAddress.valueOf("A12:F12"),
             CellRangeAddress.valueOf("A17:F17"),
             CellRangeAddress.valueOf("A18:F18"),
             CellRangeAddress.valueOf("A19:F19"),
             CellRangeAddress.valueOf("A20:F20"),
             CellRangeAddress.valueOf("A21:F21"),
             CellRangeAddress.valueOf("A22:F22"),           
             CellRangeAddress.valueOf("A27:F27"),
             CellRangeAddress.valueOf("A28:F28"),
             CellRangeAddress.valueOf("A29:F29")        
        };
       

      
        /*
        Applying above created rule formatting to cells
        */
        sheetCF.addConditionalFormatting(regionsAction, rule2);
        sheetCF.addConditionalFormatting(regionsAdv, rule3);
        
        
      
        /*
         Setting coloumn header values
        */
        int mainCellIndex = 0;
      
      Cell SNO = rowMain.createCell(mainCellIndex++);
        SNO.setCellValue("SNO");
        SNO.setCellStyle(style2);
        Cell gen = rowMain.createCell(mainCellIndex++);
        gen.setCellValue("Genre");
        gen.setCellStyle(style2);
        Cell credit = rowMain.createCell(mainCellIndex++);
        credit.setCellValue("Credit Score");
        credit.setCellStyle(style2);
        Cell name = rowMain.createCell(mainCellIndex++);
        name.setCellValue("Album Name");
        name.setCellStyle(style2);
        Cell art = rowMain.createCell(mainCellIndex++);
        art.setCellValue("Artist");
        art.setCellStyle(style2);
        Cell release = rowMain.createCell(mainCellIndex++);
        release.setCellValue("Release Date");
        release.setCellStyle(style2);
        
        
        
        /*
        populating cell values
        */
        int rowIndex = 4;
        int sno = 1;
        for(SongsList song : songList){
            if(song.getSno() != 0){

            Row row = songsSheet.createRow(rowIndex++);
            int cellIndex = 0;
            
            
            /*
            first place in row is Sno
            */
            row.createCell(cellIndex++).setCellValue(sno++);

            
            /*
            second place in row is  Genre
            */
            row.createCell(cellIndex++).setCellValue(song.getGenre());
                    

            
            /*
            third place in row is Critic score
            */
            row.createCell(cellIndex++).setCellValue(song.getCriticscore());

            
            /*
            fourth place in row is Album name
            */
            row.createCell(cellIndex++).setCellValue(song.getAlbumname());
            
            
            /*
            fifth place in row is Artist
            */
            row.createCell(cellIndex++).setCellValue(song.getArtist());
            
            
            /*
            sixth place in row is marks in date
            */
            if (song.getReleasedate() != null){
                
                Cell date = row.createCell(cellIndex++);
                
                DataFormat format = workbook.createDataFormat();
                CellStyle dateStyle = workbook.createCellStyle(); 
                dateStyle.setDataFormat(format.getFormat("dd-MMM-yyyy"));
                date.setCellStyle(dateStyle);  

           
            date.setCellValue(song.getReleasedate());
            
            
            /*
            auto-resizing columns
            */
            songsSheet.autoSizeColumn(6);
            songsSheet.autoSizeColumn(5);
            songsSheet.autoSizeColumn(4);
            songsSheet.autoSizeColumn(3);
            songsSheet.autoSizeColumn(2);
            }
            

        }
    }
        
        /*
        writing this workbook to excel file.
        */
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            fos.close();

            System.out.println(FILE_PATH + " is successfully written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }
}