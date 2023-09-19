package claranet.cdp.adapters.secondary.restapis.event;

import claranet.cdp.adapters.secondary.restapis.event.models.EventModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Repository which allows you to retrieve events from the database
 */
@Transactional(readOnly = true)
public interface EventJpaReadRepository extends Repository<EventModel, Long> {

    EventModel findById(Long id);

    List<EventModel> findAll();

    @Query("SELECT eve, ban, mem" +
            " FROM Event eve" +
            " JOIN eve.bands ban" +
            " JOIN ban.members mem" +
            " WHERE mem.name LIKE %?1%")
    List<EventModel> searchAllByBandsContainsMembersWithName(String query);
}
