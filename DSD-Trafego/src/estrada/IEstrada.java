/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada;

import java.awt.Point;

/**
 *
 * @author Bruno Zilli Sgrott
 */
interface IEstrada {

    EstradaType getType();
    
    Point getPoint();
    
    void accept(IEstradaVisitor visitor);
}
