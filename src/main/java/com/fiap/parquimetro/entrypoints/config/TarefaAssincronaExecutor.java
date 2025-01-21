package com.fiap.parquimetro.entrypoints.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class TarefaAssincronaExecutor implements CommandLineRunner {

    @Autowired
    private InserirEstacionamentoRunnable inserirEstacionamentoRunnable;

    @Override
    public void run(String... args) throws Exception {
        // Executor com um pool de threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submetendo o Runnable ao executor
        executor.submit(inserirEstacionamentoRunnable);
        
        // Fechar o executor
        executor.shutdown();
    }
}
