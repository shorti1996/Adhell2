package pl.shorti1996.testest.dagger.component;

import pl.shorti1996.testest.adapter.AdhellPermissionInAppsAdapter;
import pl.shorti1996.testest.blocker.ContentBlocker20;
import pl.shorti1996.testest.blocker.ContentBlocker56;
import pl.shorti1996.testest.dagger.module.AdminModule;
import pl.shorti1996.testest.dagger.module.AppModule;
import pl.shorti1996.testest.dagger.module.EnterpriseModule;
import pl.shorti1996.testest.dagger.module.NetworkModule;
import pl.shorti1996.testest.dagger.scope.AdhellApplicationScope;
import pl.shorti1996.testest.fragments.BlockedUrlSettingFragment;
import pl.shorti1996.testest.fragments.BlockerFragment;
import pl.shorti1996.testest.fragments.PackageDisablerFragment;
import pl.shorti1996.testest.service.BlockedDomainService;
import pl.shorti1996.testest.utils.AdhellAppIntegrity;
import pl.shorti1996.testest.utils.AppsListDBInitializer;
import pl.shorti1996.testest.utils.DeviceAdminInteractor;
import pl.shorti1996.testest.viewmodel.AdhellWhitelistAppsViewModel;
import pl.shorti1996.testest.viewmodel.SharedAppPermissionViewModel;

import dagger.Component;

@AdhellApplicationScope
@Component(modules = {AppModule.class, AdminModule.class, EnterpriseModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(DeviceAdminInteractor deviceAdminInteractor);

    void inject(ContentBlocker56 contentBlocker56);

    void inject(ContentBlocker20 contentBlocker20);

    void inject(BlockedDomainService blockedDomainService);

    void inject(BlockedUrlSettingFragment blockedUrlSettingFragment);

    void inject(PackageDisablerFragment packageDisablerFragment);

    void inject(AdhellWhitelistAppsViewModel adhellWhitelistAppsViewModel);

    void inject(SharedAppPermissionViewModel sharedAppPermissionViewModel);

    void inject(AdhellPermissionInAppsAdapter adhellPermissionInAppsAdapter);

    void inject(AppsListDBInitializer appsListDBInitializer);

    void inject(BlockerFragment blockerFragment);

    void inject(AdhellAppIntegrity adhellAppIntegrity);

}
