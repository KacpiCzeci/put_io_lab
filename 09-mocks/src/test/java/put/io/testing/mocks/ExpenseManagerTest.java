package put.io.testing.mocks;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;
import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManagerTest {

    @Test
    public void testcalculateTotal() {
        ExpenseRepository mockExpenceRepository = mock(ExpenseRepository.class);
        FancyService mockFancyService = mock(FancyService.class);

        List<Expense> Expences = new ArrayList<Expense>();
        for(int i=0; i<3; i++){
            Expense Exp = new Expense();
            Exp.setAmount(10*i);
            Exp.setCategory("Category");
            Exp.setTitle("Expence "+i);
            Expences.add(Exp);
        }

        when(mockExpenceRepository.getExpenses()).thenReturn(Expences);

        ExpenseManager ExpMan = new ExpenseManager(mockExpenceRepository, mockFancyService);
        long result = ExpMan.calculateTotal();

        verify(mockExpenceRepository).getExpenses();
        assertEquals(30, result);
    }

    @Test
    public void testcalculateTotalForCategoryHome() {
        ExpenseRepository mockExpRep = mock(ExpenseRepository.class);
        FancyService mockFancyService = mock(FancyService.class);

        List<Expense> Expences = new ArrayList<Expense>();
        for(int i=0; i<2; i++){
            Expense Exp = new Expense();
            Exp.setAmount(10*i);
            Exp.setCategory("Home");
            Exp.setTitle("Expence "+i);
            Expences.add(Exp);
        }

        when(mockExpRep.getExpensesByCategory("Home")).thenReturn(Expences);

        ExpenseManager ExpMan = new ExpenseManager(mockExpRep, mockFancyService);
        long result = ExpMan.calculateTotalForCategory("Home");

        verify(mockExpRep).getExpensesByCategory("Home");
        assertEquals(10, result);
    }

    @Test
    public void testcalculateTotalForCategoryCar() {
        ExpenseRepository mockExpRep = mock(ExpenseRepository.class);
        FancyService mockFancyService = mock(FancyService.class);

        List<Expense> Expences = new ArrayList<Expense>();
        for(int i=0; i<3; i++){
            Expense Exp = new Expense();
            Exp.setAmount(10*i);
            Exp.setCategory("Car");
            Exp.setTitle("Expence "+i);
            Expences.add(Exp);
        }

        when(mockExpRep.getExpensesByCategory("Car")).thenReturn(Expences);

        ExpenseManager ExpMan = new ExpenseManager(mockExpRep, mockFancyService);
        long result = ExpMan.calculateTotalForCategory("Car");

        verify(mockExpRep).getExpensesByCategory("Car");
        assertEquals(30, result);
    }

    @Test
    public void testcalculateTotalForCategoryFood() {
        ExpenseRepository mockExpRep = mock(ExpenseRepository.class);
        FancyService mockFancyService = mock(FancyService.class);

        when(mockExpRep.getExpensesByCategory("Food")).thenReturn(Collections.emptyList());

        ExpenseManager ExpMan = new ExpenseManager(mockExpRep, mockFancyService);
        long result = ExpMan.calculateTotalForCategory("Food");

        verify(mockExpRep).getExpensesByCategory("Food");
        assertEquals(0, result);
    }

    @Test
    public void testcalculateTotalForCategorySport() {
        ExpenseRepository mockExpRep = mock(ExpenseRepository.class);
        FancyService mockFancyService = mock(FancyService.class);

        when(mockExpRep.getExpensesByCategory("Sport")).thenReturn(Collections.emptyList());

        ExpenseManager ExpMan = new ExpenseManager(mockExpRep, mockFancyService);
        long result = ExpMan.calculateTotalForCategory("Sport");

        verify(mockExpRep).getExpensesByCategory("Sport");
        assertEquals(0, result);
    }

    @Test
    public void testcalculateTotalInDollars() throws ConnectException {
        ExpenseRepository mockExpRep = mock(ExpenseRepository.class);
        FancyService mockFancyService = mock(FancyService.class);

        Expense Exp = new Expense();
        Exp.setTitle("Expence");
        Exp.setCategory("Category");
        Exp.setAmount(40);

        List<Expense> Expences = new ArrayList<Expense>();
        Expences.add(Exp);
        when(mockExpRep.getExpenses()).thenReturn(Expences);
        when(mockFancyService.convert(anyDouble(), eq("PLN"),eq("USD"))).thenAnswer((Answer) invocation -> {
            Object[] args = invocation.getArguments();
            return (double) args[0] / 4;
        });

        ExpenseManager ExpMan = new ExpenseManager(mockExpRep, mockFancyService);
        double converted = ExpMan.calculateTotalInDollars();

        verify(mockFancyService).convert(anyDouble(), eq("PLN"), eq("USD"));
        assertEquals(10.0, converted);
    }
}
