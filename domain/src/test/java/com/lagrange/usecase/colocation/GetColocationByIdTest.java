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

import static com.lagrange.usecase.colocation.ColocationFixture.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GetColocationByIdTest {

    @Mock
    private ColocationRepository colocationRepository;

    @InjectMocks
    private GetColocationById getColocationById;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetColocationById() {
        ColocationId colocationId = colocationID();
        when(colocationRepository.getColocationById(colocationId)).thenReturn(createColocation());
        Colocation colocation = getColocationById.getColocation(colocationId);
        assertEquals(createColocation(), colocation);
    }
}
