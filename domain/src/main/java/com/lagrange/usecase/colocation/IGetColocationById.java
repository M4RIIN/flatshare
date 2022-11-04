package com.lagrange.usecase.colocation;

import com.lagrange.entity.colocation.Colocation;
import com.lagrange.entity.colocation.ColocationId;

public interface IGetColocationById {
    Colocation getColocation(ColocationId colocationId);
}
