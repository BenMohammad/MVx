package com.fukuni.mvx.screens.questiondetails;

import com.fukuni.mvx.questions.QuestionDetails;
import com.fukuni.mvx.screens.common.navdrawer.DrawerItems;
import com.fukuni.mvx.screens.common.navdrawer.NavDrawerViewMvc;
import com.fukuni.mvx.screens.common.views.ObservableViewMvc;
import com.fukuni.mvx.screens.common.views.ViewMvc;

public interface QuestionDetailsViewMvc extends ObservableViewMvc<QuestionDetailsViewMvc.Listener>, NavDrawerViewMvc {

    public interface Listener {
        void onNavigateUpClicked();
        void onDrawerItemClicked(DrawerItems items);
    }

    void bindQuestion(QuestionDetails questionDetails);
    void showProgress();
    void hideProgress();
}
