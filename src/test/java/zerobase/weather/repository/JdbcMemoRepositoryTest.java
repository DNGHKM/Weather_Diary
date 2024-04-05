package zerobase.weather.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JdbcMemoRepository;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class JdbcMemoRepositoryTest {
    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest(){
        //given
        Memo memo = new Memo(2, "insert Memo test");

        //when
        jdbcMemoRepository.save(memo);

        //then
        Optional<Memo> result = jdbcMemoRepository.findById(2);
        Assertions.assertEquals("insert Memo test", result.get().getText());
    }
    
    @Test
    void findAllMemoTest(){
    List<Memo> memoList = jdbcMemoRepository.findAll();
    System.out.println(memoList);
    Assertions.assertNotNull(memoList);
    }
    
}
