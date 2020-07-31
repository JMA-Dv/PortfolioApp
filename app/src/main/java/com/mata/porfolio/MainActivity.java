package com.mata.porfolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mata.porfolio.contactme.ContactFragment;
import com.mata.porfolio.cv.CVFragment;
import com.mata.porfolio.home.HomeFragment;
import com.mata.porfolio.portfolio.PortfolioFragment;
import com.mata.porfolio.sidemenu.Callback;
import com.mata.porfolio.sidemenu.MenuAdapter;
import com.mata.porfolio.sidemenu.MenuItem;
import com.mata.porfolio.sidemenu.MenuUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {

    RecyclerView menuRecycler;
    List<MenuItem> menuItems ;
    MenuAdapter menuAdapter;
    int menuSelected = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setPorfolioFrament();
        setSideMenu();
        //setContactFragment();
        //setFragment();
        setHomeFragment();
    }
    private void setSideMenu(){
        menuRecycler = findViewById(R.id.rv_side_menu);
        menuItems = MenuUtil.getMenuList();
        menuAdapter = new MenuAdapter(menuItems,this);
        menuRecycler.setLayoutManager(new LinearLayoutManager(this));
        menuRecycler.setAdapter(menuAdapter);

    }
    public void setPorfolioFrament(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PortfolioFragment()).commit();
    }
    public void setContactFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ContactFragment()).commit();
    }
    public void setCVFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CVFragment()).commit();
    }
    public void setHomeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }


    @Override
    public void onSideMenuClick(int i) {
        switch(menuItems.get(i).getCode()){
            case  MenuUtil.HOME_FRAGMENT_CODE: setHomeFragment();
            break;
            case  MenuUtil.CV_FRAGMENT_CODE: setCVFragment();
                break;
            case  MenuUtil.CONTACT_FRAGMENT_CODE: setContactFragment();
                break;
            case  MenuUtil.PORTFOLIO_FRAGMENT_CODE: setPorfolioFrament();
                break;
            default : setHomeFragment();


        }
        menuItems.get(menuSelected).setSelected(false);
        menuItems.get(i).setSelected(true);
        menuSelected = i;
        menuAdapter.notifyDataSetChanged();

    }
}
