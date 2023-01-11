/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricketscorecard;

/**
 *
 * @author sai
 */
public class strikeUpdate {
    static void strikeUpdate(int runs){
        if(runs%2!=0){
                if(firstInningsJFrame.StrikePlayer){
                    firstInningsJFrame.StrikePlayer=false;
                }
                else{
                    firstInningsJFrame.StrikePlayer=true;
                }
        }
    }
    
}
