package lab4.task4_1.service;

import lab4.task4_1.model.animal.Eagle;
import lab4.task4_1.model.animal.Lion;
import lab4.task4_1.model.animal.Zebra;
import lab4.task4_1.model.aviary.BirdAviary;
import lab4.task4_1.model.aviary.LionAviary;
import lab4.task4_1.model.aviary.UngulateAviary;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ZooTest {

    @Test
    public void should_countAnimals_when_aviariesIsNotEmpty() {
        //given
        Zoo zoo = new Zoo();
        List.of(
                new LionAviary<>(
                        10, List.of(new Lion("l1"), new Lion("l2"))
                ),
                new BirdAviary<>(5, List.of(
                        new Eagle("e1"), new Eagle("e2")))
        ).forEach(zoo::addAviary);
        //when
        long animalsCount = zoo.getCountOfAnimals();
        zoo.addAviary(new UngulateAviary<>(2, List.of(new Zebra("z1"))));
        long newAnimalsCount = zoo.getCountOfAnimals();
        //then
        assertThat(animalsCount).isEqualTo(4);
        assertThat(newAnimalsCount).isEqualTo(5);
    }


}