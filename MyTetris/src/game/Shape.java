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
public abstract class Shape {//虚类
    public abstract void next();//得到下一个状态
    public abstract void forword();//得到前一个状态
    public abstract int[] getCurrentBlocks();//获取当前状态
}
