package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

import org.junit.*;
import org.mockito.*;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.Collections;

public class ExpenseRepositoryTest {

    @Test
    public void testloadExpencesClass() {
        ExpenseRepository ExpRep = new ExpenseRepository(new MyDatabase());
        ExpRep.loadExpenses();
        assertEquals(ExpRep.getExpenses(), Collections.emptyList());
    }

    @Test
    public void testloadExpencesMock() {
        IFancyDatabase mockObject = mock(IFancyDatabase.class);
        when(mockObject.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository ExpRep = new ExpenseRepository(mockObject);
        ExpRep.loadExpenses();

        verify(mockObject).connect();
        verify(mockObject).queryAll();
        verify(mockObject).close();

        InOrder inOrder = inOrder(mockObject);
        inOrder.verify(mockObject).connect();
        inOrder.verify(mockObject).queryAll();
        inOrder.verify(mockObject).close();

        assertEquals(ExpRep.getExpenses(), Collections.emptyList());
    }
}
