import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rapa on 12/05/18.
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("eatstime")
public class SupportResource {

    @POST
    @Path("support")
    public Response SupportResource(UserDetails userDetails) throws Exception {

        if (userDetails == null) {
            throw new Exception("user details  is empty");
        }

        final String email = userDetails.getEmail();
        if (StringUtils.isBlank(email)) {
            throw new Exception("Must insert email");
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.format(new Date());
        String fileName = email.concat("_").concat(df.getCalendar().getTime().toString());

        // save in disk
        File targetFile = new File("src/main/resources/" + fileName);
        List<String> strings = new ArrayList<String>();
        strings.add(new ObjectMapper().writeValueAsString(userDetails));
        FileUtils.writeLines(targetFile, strings);

        String json ="{\"message\":\" Your request has been successfully accepted\"}";
        return Response.ok(json).build();
    }


    public static void main(String[] args) throws JsonProcessingException {
        System.out.println(new ObjectMapper().writeValueAsString(new UserDetails()));
    }


}
