package fr.ath.kata.person;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ContainerTest {

    @Test
    public void shouldRegisterComponent() throws InstantiationException, IllegalAccessException {
        Container container = new Container();
        container.saveComponent(PersonRepositoryImpl.class);
        PersonRepository component = container.getComponent(PersonRepositoryImpl.class);
        assertThat(component).isNotNull();
    }

    @Test
    public void shouldRegisterComponentWithArgs() throws InstantiationException, IllegalAccessException {
        Container container = new Container();
        container.saveComponent(PersonRepositoryImpl.class);
        container.saveComponent(PersonService.class);
        PersonService component = container.getComponent(PersonService.class);
        assertThat(component.getMobSize()).isEqualTo(0);
    }

    @Test
    public void shouldNotRegisterComponentIfMissingDependencies() {
        assertThatThrownBy(() -> {
            new Container().saveComponent(PersonService.class);
        }).isInstanceOf(MissingDependenciesException.class);

    }
}
