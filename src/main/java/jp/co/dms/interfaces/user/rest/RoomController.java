package jp.co.dms.interfaces.user.rest;

import jp.co.dms.infra.persistence.jpa.JpaUserRepository;
import jp.co.dms.infra.persistence.jpa.User;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@RestController
@Path("/room")
public class RoomController {

    private JpaUserRepository userRepository;

    @GET
    public Object home() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
