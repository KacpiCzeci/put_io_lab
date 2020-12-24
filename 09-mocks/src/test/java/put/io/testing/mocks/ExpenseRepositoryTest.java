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
    public void testloadExpences() {
        ExpenseRepository ExpRep = new ExpenseRepository(new MyDatabase());
        ExpRep.loadExpenses();
        assertEquals(ExpRep.getExpenses(), Collections.emptyList());
    }
}
