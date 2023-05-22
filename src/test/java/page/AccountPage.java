package page;

import com.github.common.Constants;
import component.Header;

public class AccountPage implements IPage, Header {
    @Override
    public String getUrl() {
        return Constants.BASE_URL + "customer/account/";
    }
}
