import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by rapa on 12/05/18.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDetails {

    private String name;
    private String phone;
    private String email;
    private String feedback;

}
