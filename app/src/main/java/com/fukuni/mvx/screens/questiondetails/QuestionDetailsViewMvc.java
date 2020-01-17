package com.fukuni.mvx.screens.questiondetails;

import com.fukuni.mvx.questions.QuestionDetails;
import com.fukuni.mvx.screens.common.ViewMvc;

public interface QuestionDetailsViewMvc extends ViewMvc {

    void bindQuestion(QuestionDetails questionDetails);
    void showProgress();
    void hideProgress();
}
