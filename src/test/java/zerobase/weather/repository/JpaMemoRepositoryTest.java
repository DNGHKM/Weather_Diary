package zerobase.weather.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
class JpaMemoRepositoryTest {
    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo memo = new Memo(10, "this is jpa memo");
        //when
        jpaMemoRepository.save(memo);
        //then
        List<Memo> memoList = jpaMemoRepository.findAll();
        Assertions.assertFalse(memoList.isEmpty());
    }

    @Test
    void findById() {
        //given
        Memo memo = new Memo(11, "jpa");
        //when
        Memo savedMemo = jpaMemoRepository.save(memo);
        System.out.println(savedMemo.getId());
        //then
        Optional<Memo> result = jpaMemoRepository.findById(savedMemo.getId());
        Assertions.assertEquals(result.get().getText(), "jpa");
    }
}