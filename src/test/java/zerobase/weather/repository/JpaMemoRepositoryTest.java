package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaMemoRepositoryTest { //jpa는 java ORM 기술의 표준이다.

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo memo = Memo.builder().id(10).text("this is jpa memo").build();
        //when
       jpaMemoRepository.save(memo);

        //then
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() > 0);
    }

    @Test
    void findByIdTest() {
        //given
        Memo memo = Memo.builder().id(10).text("this is jpa memo").build();
        //when
        Memo save = jpaMemoRepository.save(memo);
        System.out.println(save.getId());
        //then
        Optional<Memo> result = jpaMemoRepository.findById(save.getId());
        assertEquals(result.get().getText(),"this is jpa memo");
    }

}