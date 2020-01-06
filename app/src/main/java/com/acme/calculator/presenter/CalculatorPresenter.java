package com.acme.calculator.presenter;

import com.acme.calculator.view.CalculatorView;

public class CalculatorPresenter implements Presenter {

    private CalculatorView view;

    public CalculatorPresenter(CalculatorView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onDestroy() {
    }


}
