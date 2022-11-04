package com.lagrange.config;

import com.lagrange.ConsoleView;
import com.lagrange.colocation.ColocationService;
import com.lagrange.mock.ColocationMock;
import com.lagrange.mock.ColocationPieceMock;
import com.lagrange.mock.PieceTacheMock;
import com.lagrange.port.colocation.ColocationRepository;
import com.lagrange.port.piecetache.PieceTacheRepository;
import com.lagrange.usecase.colocation.GetColocationById;

public class Configuration {
    public final PieceTacheRepository pieceTacheRepository = new PieceTacheMock();
    public final ColocationPieceMock colocationPieceMock = new ColocationPieceMock(pieceTacheRepository);
   public final ColocationRepository colocationRepository = new ColocationMock(colocationPieceMock, null);
    public final GetColocationById getColocationById = new GetColocationById(null);
    public final ColocationService colocationService = new ColocationService(getColocationById);
    public final ConsoleView consoleView = new ConsoleView(colocationService);
}
