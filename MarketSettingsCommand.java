package com.pelikantravel.pelijee.command;

import com.pelikantravel.settings.MarketSettingsDto;
import com.pelikantravel.settings.model.SettingsCategoryEnum;
import com.pelikantravel.utils.settings.SettingsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.http.Builder;
import utils.middleware.ApiFailException;
import utils.middleware.CommandLogLevel;
import utils.middleware.ee.CommandEE;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

/**
 * @author Marek Tomas on 15.11.2019
 */
@Stateless
public class MarketSettingsCommand extends CommandEE<MarketSettingsDto, String> {

    private static Logger log = LoggerFactory.getLogger(MarketSettingsCommand.class);

    @Inject
    private SettingsUtils settingsUtils;

    @Override
    protected String getUrl() {
        return null;
    }

    private static final String ENDPOINT_PELIJEE = "shared-data-resource/market-settings";

    @Override
    protected Integer getTimeout() {
        return settingsUtils.getInteger(SettingsCategoryEnum.SO_INTERNAL, "MARKET_SETTINGS_TIMEOUT", 2000);
    }

    @Override
    protected String getKey() {
        return "cmd.market.settings.";
    }

    @Override
    protected MarketSettingsDto run(String url) throws Exception {

        Builder<MarketSettingsDto> builder = Builder.create(Builder.Verb.GET)
                .response(MarketSettingsDto.class)
                .url(url + ENDPOINT_PELIJEE)
                .responseType(MediaType.APPLICATION_JSON_TYPE);
        return remoteExecute(builder);
    }

    @Override
    protected MarketSettingsDto getFallback(ApiFailException ex, String param) {
        return null;
    }

    @Override
    public CommandLogLevel getCommandLogLevel() {
        return CommandLogLevel.NONE;
    }

    @Override
    protected boolean checkPrerequisites() {
        if (getTimeout() == null) {
            log.error("Prerequisites fail: getTimeout");
            return false;
        }
        return true;
    }

}
