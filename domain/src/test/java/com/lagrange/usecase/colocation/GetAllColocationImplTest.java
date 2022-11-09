package com.lagrange.usecase.colocation;

import com.lagrange.entity.colocation.Colocation;
import com.lagrange.entity.colocation.ColocationId;
import com.lagrange.port.colocation.ColocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.lagrange.usecase.colocation.ColocationFixture.colocationID;
import static com.lagrange.usecase.colocation.ColocationFixture.createColocation;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GetAllColocationImplTest {

    @Mock
    private ColocationRepository colocationRepository;

    @InjectMocks
    private GetAllColocationImpl getAllColocation;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetAllColocations() {
        when(colocationRepository.getAll()).thenReturn(List.of(createColocation(),createColocation()));
        List<Colocation> colocations = getAllColocation.apply();
        assertEquals(2, colocations.size());
    }

}
