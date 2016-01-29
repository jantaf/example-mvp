package me.janta.example_mvp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import me.janta.example_mvp.models.Element;
import me.janta.example_mvp.models.MainInteractor;
import me.janta.example_mvp.presenters.MainPresenterImpl;
import me.janta.example_mvp.views.MainView;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * Created by Jorge on 27/1/16.
 * Modify by Jorge.
 */
public class MainPresenterTest {
    private static ArrayList<Element> ELEMENTS;
    @Mock
    private MainView mMainView;
    @Mock
    private MainInteractor mMainInteractor;
    @Captor
    private ArgumentCaptor<ArrayList<Element>> mLoadElementsCallbackCaptor;

    private MainPresenterImpl mMainPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainPresenter = new MainPresenterImpl(mMainView);
    }

    @Test
    public void testLoadElementsInData() throws Exception {
        mMainPresenter.getElementsFromData();
        verify(mMainView).setElements(mLoadElementsCallbackCaptor.capture());
        assertEquals(mLoadElementsCallbackCaptor.getValue().size(), 5);


    }

    @Test
    public void testAddElementInData() throws Exception {
        mMainPresenter.addElement("test", "test");
        mMainPresenter.getElementsFromData();
        verify(mMainView).setElements(mLoadElementsCallbackCaptor.capture());
        ELEMENTS = mLoadElementsCallbackCaptor.getValue();
        assertEquals(ELEMENTS.get(0).getName(), "test");

    }
}
