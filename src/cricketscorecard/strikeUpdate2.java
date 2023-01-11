/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricketscorecard;

/**
 *
 * @author sai
 */
public class strikeUpdate2 {
    static void strikeUpdate2(int runs){
        if(runs%2!=0){
                if(secondInnings.StrikePlayer){
                    secondInnings.StrikePlayer=false;
                }
                else{
                    secondInnings.StrikePlayer=true;
                }
        }
    }
}
