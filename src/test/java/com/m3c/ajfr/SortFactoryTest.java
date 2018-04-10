package com.m3c.ajfr;
import com.m3c.ajfr.controller.SortFactory;
import com.m3c.ajfr.controller.SortFactoryException;
import com.m3c.ajfr.sorters.Sorter;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
public class SortFactoryTest {

    SortFactory sf = new SortFactory();

    @Test
    public void getSorter() throws SortFactoryException {
        Sorter sorter = sf.getInstance();
        assertEquals(true, sorter instanceof Sorter);
    }
}
