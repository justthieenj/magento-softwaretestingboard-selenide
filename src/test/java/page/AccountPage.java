package page;

import com.github.common.Constants;

public class AccountPage implements IPage {
    @Override
    public String getUrl() {
        return Constants.BASE_URL + "customer/account/";
    }
}
