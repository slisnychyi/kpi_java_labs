package lab4.task4_1.model.aviary;

import lab4.task4_1.model.animal.Lion;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AviaryTest {

    @Test
    public void should_addAnimal_when_aviaryIsNotFull() {
        //given
        Aviary<Lion> animalAviary = new LionAviary<>(10);
        //when
        Lion lion = new Lion("l1");
        animalAviary.addAnimal(lion);
        //then
        assertThat(animalAviary.getMaxSize()).isEqualTo(10);
        assertThat(animalAviary.getSize()).isEqualTo(1);
        assertThat(animalAviary.isExist(lion)).isTrue();
    }

    @Test
    public void should_removeAnimal_when_animalExists() {
        //given
        Lion lion = new Lion("l1");
        Aviary<Lion> animalAviary = new LionAviary<>(10, List.of(lion));
        //when
        animalAviary.removeAnimal(lion);
        //then
        assertThat(animalAviary.getMaxSize()).isEqualTo(10);
        assertThat(animalAviary.getSize()).isEqualTo(0);
        assertThat(animalAviary.isExist(lion)).isFalse();
    }

    @Test
    public void should_notAddAnimal_when_aviaryIsFull() {
        //given
        Lion lion = new Lion("l1");
        Aviary<Lion> animalAviary = new LionAviary<>(1, List.of(lion));
        //when
        assertThatThrownBy(() -> animalAviary.addAnimal(new Lion("l2")))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("full");
    }

    @Test
    public void should_notRemoveAnimal_when_animalDoesNotExist() {
        //given
        Lion lion = new Lion("l1");
        Aviary<Lion> animalAviary = new LionAviary<>(1, List.of(lion));
        //when
        assertThatThrownBy(() -> animalAviary.removeAnimal(new Lion("l2")))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no such animal");
    }


}