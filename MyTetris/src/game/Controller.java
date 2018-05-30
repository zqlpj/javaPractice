/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author brook
 */
public class Controller {
    public int[] getAShape(){
        BlockT bt = new BlockT();
        return bt.blocks[bt.state];
    }
    int currentX=1,currentY=0;
}
