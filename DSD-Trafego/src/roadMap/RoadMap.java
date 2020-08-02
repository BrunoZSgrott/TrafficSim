/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadMap;

import java.awt.Point;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class RoadMap {

    private int[][] mapa;
    private int linha;
    private int coluna;
    private int count;

    public RoadMap(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        clear();
    }

    public int size() {
        return linha * coluna;
    }

    public void add(int x, int y, int value) {
        mapa[x][y] = value;
        if (value != 0) {
            count++;
        }
    }

    public int getValue(int x, int y) {
        return mapa[x][y];
    }

    public void clear() {
        mapa = new int[linha][coluna];
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

}
