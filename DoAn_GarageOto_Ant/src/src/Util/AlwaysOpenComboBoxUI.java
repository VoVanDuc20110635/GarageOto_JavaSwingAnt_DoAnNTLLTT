/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Util;

import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author WINDOWS 10
 */
public class AlwaysOpenComboBoxUI extends BasicComboBoxUI{
    @Override
    public boolean isPopupVisible(JComboBox c) {
            return true;
        }
    
}
