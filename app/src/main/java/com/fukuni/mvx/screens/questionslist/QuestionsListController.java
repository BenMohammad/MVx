package com.fukuni.mvx.screens.questionslist;

import com.fukuni.mvx.questions.FetchLastActiveQuestionsUseCase;
import com.fukuni.mvx.questions.Question;
import com.fukuni.mvx.screens.common.messagedisplayer.MessagesDisplayer;
import com.fukuni.mvx.screens.common.screennavigator.ScreenNavigator;

import java.util.List;

public class QuestionsListController implements QuestionsListViewMvcImpl.Listener, FetchLastActiveQuestionsUseCase.Listener {

    private final FetchLastActiveQuestionsUseCase fetchLastActiveQuestionsUseCase;
    private final MessagesDisplayer messagesDisplayer;
    private final ScreenNavigator screenNavigator;
    private QuestionsListViewMvc mViewMvc;

    public QuestionsListController(FetchLastActiveQuestionsUseCase fetchLastActiveQuestionsUseCase, MessagesDisplayer messagesDisplayer, ScreenNavigator screenNavigator) {
        this.fetchLastActiveQuestionsUseCase = fetchLastActiveQuestionsUseCase;
        this.messagesDisplayer = messagesDisplayer;
        this.screenNavigator = screenNavigator;
    }

    public void bindView(QuestionsListViewMvc viewMvc) {
        mViewMvc = viewMvc;
        mViewMvc.registerListener(this);
    }

    public void onStart() {
        fetchLastActiveQuestionsUseCase.registerListener(this);
        mViewMvc.showProgress();
        fetchLastActiveQuestionsUseCase.fetchLastActiveQuestionsAndNotify();
    }

    public void onStop() {
        fetchLastActiveQuestionsUseCase.unregisterListener(this);
    }

    @Override
    public void onLastActiveQuestionFetched(List<Question> questions) {
        mViewMvc.hideProgress();
        mViewMvc.bindQuestions(questions);
    }

    @Override
    public void onLastActiveQuestionFetchedFailed() {
        mViewMvc.hideProgress();
        messagesDisplayer.showUSeCaseError();
    }

    @Override
    public void onQuestionClicked(Question question) {
        screenNavigator.toDialogDetails(question.getId());
    }
}
