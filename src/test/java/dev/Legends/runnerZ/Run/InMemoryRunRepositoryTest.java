//package dev.Legends.runnerZ.Run;
//
//import dev.danvega.runnerz.run.InMemoryRunRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.*;
//
//class InMemoryRunRepositoryTest {
//    dev.danvega.runnerz.run.InMemoryRunRepository repository;
//
//    @BeforeEach
//    void setUp(){
//        repository = new InMemoryRunRepository();
//        repository.create(new Run(1,
//                "morning run",
//                LocalDateTime.now(),
//                LocalDateTime.now().plusHours(1),
//                5,
//               Location.OUTDOOR,null));
//        repository.create(new Run(2,
//                "Evening run",
//                LocalDateTime.now(),
//                LocalDateTime.now().plusHours(2),
//                5,
//                Location.INDOOR,null));
//    }
//
//    @Test
//    void shouldFindAllRuns(){
//        List<Run> runs = repository.findAll();
//        assertEquals(2,runs.size(),"should find all runs");
//    }
//
//
//    @Test
//    void shouldFindRunWithValidId() {
//        var run = repository.findById(1).get();
//        assertEquals("morning run", run.title());
//        assertEquals(3, run.miles());
//    }
//
//    @Test
//    void shouldNotFindRunWithInvalidId() {
//        RunNotFoundException notFoundException = assertThrows(
//                RunNotFoundException.class,
//                () -> repository.findById(3).get()
//        );
//
//        assertEquals("Run Not Found", notFoundException.getMessage());
//    }
//
//    @Test
//    void shouldCreateNewRun() {
//        repository.create(new Run(3,
//                "Friday Morning Run",
//                LocalDateTime.now(),
//                LocalDateTime.now().plusMinutes(30),
//                3,
//                Location.INDOOR,null));
//        List<Run> runs = repository.findAll();
//        assertEquals(3, runs.size());
//    }
//
//    @Test
//    void shouldUpdateRun() {
//        repository.update(new Run(1,
//                "morning run",
//                LocalDateTime.now(),
//                LocalDateTime.now().plusMinutes(30),
//                5,
//                Location.OUTDOOR,null), 1);
//        var run = repository.findById(1).get();
//        assertEquals("morning run", run.title());
//        assertEquals(5, run.miles());
//        assertEquals(Location.OUTDOOR, run.location());
//    }
//
//    @Test
//    void shouldDeleteRun() {
//        repository.delete(1);
//        List<Run> runs = repository.findAll();
//        assertEquals(1, runs.size());
//    }
//}