package Controller;

import DataBase.DBclass;
import Interface.Security;

import java.util.HashMap;

public class secure implements Security {

    DBclass db;

    public secure(DBclass db) {
        this.db = db;
    }

    //to check if dealer is authorizied
    @Override
    public boolean IsDealerAuthorized(String dealerid, String dealeraccesskey) {

        if(dealerid.equalsIgnoreCase("") || dealeraccesskey.equalsIgnoreCase(""))
        {
            return false;
        }
        HashMap<String,String> mockdelaer=db.getDealerData();

        if(mockdelaer.containsKey(dealerid))
        {
            if(mockdelaer.get(dealerid).equals(dealeraccesskey))
            {
                return true;
            }
        }

        return false;
    }
}
