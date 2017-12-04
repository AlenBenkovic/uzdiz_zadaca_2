/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.iterator;

import java.util.ArrayList;
import java.util.List;
import uzdiz_zadaca_2.composite.Mjesto;

/**
 *
 * @author abenkovic
 */
public class MjestoIterator implements Iterator {

    List<Mjesto> mjesta;
    int position = 0;

    public MjestoIterator(List<Mjesto> mjesta) {

        this.mjesta = new ArrayList<Mjesto>();
        this.sort(mjesta);

    }

    
    @Override
    public boolean hasNext() {
        if (position >= this.mjesta.size()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Mjesto next() {
        Mjesto mjesto = this.mjesta.get(position);
        position++;
        return mjesto;
    }
    
    private void sort(List<Mjesto> nesortiranaMjesta) {
        int min = 1001;
        int tmpPosition = 0;

        for (int i = 0; i < nesortiranaMjesta.size(); i++) {
            if (nesortiranaMjesta.get(i).id < min) {
                min = nesortiranaMjesta.get(i).id;
                tmpPosition = i;
            }
        }
        
        this.mjesta.add(nesortiranaMjesta.get(tmpPosition));
        nesortiranaMjesta.remove(tmpPosition);
        if (!nesortiranaMjesta.isEmpty()) {
            this.sort(nesortiranaMjesta);
        }

    }

}
