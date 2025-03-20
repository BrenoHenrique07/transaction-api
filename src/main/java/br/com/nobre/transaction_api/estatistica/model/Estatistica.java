package br.com.nobre.transaction_api.estatistica.model;

import br.com.nobre.transaction_api.estatistica.controller.EstatisticaController;

import java.math.BigDecimal;

public class Estatistica {

    private int count;
    BigDecimal sum;
    BigDecimal min;
    BigDecimal max;
    BigDecimal avg;

    public Estatistica() {
        this.count = 0;
        this.sum = BigDecimal.ZERO;
        this.min = BigDecimal.ZERO;
        this.max = BigDecimal.ZERO;
        this.avg = BigDecimal.ZERO;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public BigDecimal getAvg() {
        return avg;
    }

    public void setAvg(BigDecimal avg) {
        this.avg = avg;
    }
}
