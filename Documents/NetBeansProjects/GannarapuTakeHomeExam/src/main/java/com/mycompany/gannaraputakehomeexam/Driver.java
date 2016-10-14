/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gannaraputakehomeexam;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author S525717
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     /*
        creating object of ReadfromExcel class
        */
         ReadingFromExcel rd = new ReadingFromExcel();
         List songList = rd.getSongsListFromExcel();
         System.out.println(songList);
         
         
       /*
         Sorting the list
         */
        Collections.sort(songList,new Comparator<SongsList>(){
        
        
        /*
            Sorting by Genre
            */
	@Override
	public int compare(SongsList arg0, SongsList arg1) {
		
		return arg0.getGenre().compareTo(arg1.getGenre());
	}
        });
         Collections.sort(songList, new Comparator<SongsList>(){

        
        
        /*
             Sorting  by Critic score
             */
	@Override
	public int compare(SongsList o1, SongsList o2) {
		// TODO Auto-generated method stub
		if(o1.getGenre().equals(o2.getGenre())){
			
			if(o2.getCriticscore()-o1.getCriticscore()<0)
				return -1;
			else if(o2.getCriticscore()-o1.getCriticscore()>0)
				return 1;
			else return 0;
		}
		else{
			
			return 1;
		}
	}
          });
            
         
         
         /*
         Writing to excel
         */
         WritingToExcel wr = new WritingToExcel();
         
         wr.writeSongsToExcel(songList);
     }
    
}
