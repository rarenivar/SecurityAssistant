package com.rarenivar.securityassistant.data;

import com.rarenivar.securityassistant.data.entity.DecisionRule;
import com.rarenivar.securityassistant.data.entity.Permission;
import com.rarenivar.securityassistant.data.entity.PermissionExcludedXref;
import com.rarenivar.securityassistant.data.entity.PermissionIncludedXref;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public static List<Permission> generatePermissions() {
        List<Permission> permissionList = new ArrayList<>();
        permissionList.add(new Permission(5,"android.permission.INTERNET"));
        permissionList.add(new Permission(6,"android.permission.READ_EXTERNAL_STORAGE"));
        permissionList.add(new Permission(7,"android.permission.WRITE_EXTERNAL_STORAGE"));
        permissionList.add(new Permission(8,"android.permission.SEND_SMS"));
        permissionList.add(new Permission(9,"android.permission.WRITE_SMS"));
        permissionList.add(new Permission(10,"android.permission.WAKE_LOCK"));
        permissionList.add(new Permission(11,"android.permission.CALL_PHONE"));
        permissionList.add(new Permission(12,"android.permission.READ_SMS"));
        permissionList.add(new Permission(13,"android.permission.READ_PHONE_STATE"));
        permissionList.add(new Permission(14,"android.permission.ACCESS_FINE_LOCATION"));
        permissionList.add(new Permission(15,"android.permission.ACCESS_NETWORK_STATE"));
        permissionList.add(new Permission(16,"android.permission.READ_CONTACTS"));
        permissionList.add(new Permission(17,"android.permission.BROADCAST_STICKY"));
        permissionList.add(new Permission(18,"android.permission.DISABLE_KEYGUARD"));
        permissionList.add(new Permission(19,"android.permission.READ_CALL_LOG"));
        permissionList.add(new Permission(20,"android.permission.RECEIVE_WAP_PUSH"));
        permissionList.add(new Permission(21,"android.permission.CHANGE_WIFI_STATE"));
        permissionList.add(new Permission(22,"android.permission.SYSTEM_ALERT_WINDOW"));
        permissionList.add(new Permission(23,"android.permission.WRITE_HISTORY_BOOKMARKS"));
        permissionList.add(new Permission(24,"android.permission.READ_HISTORY_BOOKMARKS"));
        permissionList.add(new Permission(25,"android.permission.ACCESS_WIFI_STATE"));
        permissionList.add(new Permission(26,"android.permission.RECEIVE_SMS"));
        permissionList.add(new Permission(27,"android.permission.RESTART_PACKAGES"));
        permissionList.add(new Permission(28,"android.permission.RECORD_AUDIO"));
        permissionList.add(new Permission(29,"android.permission.VIBRATE"));
        permissionList.add(new Permission(30,"android.permission.BLUETOOTH_ADMIN"));
        permissionList.add(new Permission(31,"android.permission.GET_ACCOUNTS"));
        permissionList.add(new Permission(32,"android.permission.READ_SYNC_SETTINGS"));
        permissionList.add(new Permission(33,"android.permission.ACCESS_LOCATION_EXTRA_COMMANDS"));
        permissionList.add(new Permission(34,"android.permission.ACCESS_MOCK_LOCATION"));
        permissionList.add(new Permission(35,"android.permission.KILL_BACKGROUND_PROCESSES"));
        permissionList.add(new Permission(36,"android.permission.CAMERA"));
        permissionList.add(new Permission(37,"android.permission.WRITE_OWNER_DATA"));
        permissionList.add(new Permission(38,"android.permission.ACCESS_COARSE_LOCATION"));
        permissionList.add(new Permission(39,"android.permission.PROCESS_OUTGOING_CALLS"));
        permissionList.add(new Permission(40,"android.permission.GET_TASKS"));
        permissionList.add(new Permission(41,"android.permission.CHANGE_NETWORK_STATE"));
        permissionList.add(new Permission(42,"android.permission.USE_CREDENTIALS"));
        permissionList.add(new Permission(43,"android.permission.CHANGE_CONFIGURATION"));
        permissionList.add(new Permission(44,"android.permission.SET_WALLPAPER"));
        permissionList.add(new Permission(45,"android.permission.WRITE_SETTINGS"));
        permissionList.add(new Permission(46,"android.permission.READ_OWNER_DATA"));
        permissionList.add(new Permission(47,"android.permission.EXPAND_STATUS_BAR"));
        permissionList.add(new Permission(48,"android.permission.CLEAR_APP_CACHE"));
        permissionList.add(new Permission(49,"android.permission.BIND_WALLPAPER"));
        permissionList.add(new Permission(50,"android.permission.FLASHLIGHT"));
        permissionList.add(new Permission(51,"android.permission.BLUETOOTH"));
        permissionList.add(new Permission(52,"android.permission.RECEIVE_BOOT_COMPLETED"));
        return permissionList;
    }

    public static List<DecisionRule> generateDecisionRules() {
        List<DecisionRule> decisionRuleList = new ArrayList<>();
        decisionRuleList.add(new DecisionRule(0,281,1,99.7f));
        decisionRuleList.add(new DecisionRule(1,189,1,99.6f));
        decisionRuleList.add(new DecisionRule(2,286,1,99.5f));
        decisionRuleList.add(new DecisionRule(3,261,1,99.3f));
        decisionRuleList.add(new DecisionRule(4,109,1,99.2f));
        decisionRuleList.add(new DecisionRule(5,266,1,99.2f));
        decisionRuleList.add(new DecisionRule(6,206,1,99.1f));
        decisionRuleList.add(new DecisionRule(7,212,1,99.1f));
        decisionRuleList.add(new DecisionRule(8,293,1,98.9f));
        decisionRuleList.add(new DecisionRule(9,215,1,98.9f));
        decisionRuleList.add(new DecisionRule(10,44,1,98.9f));
        decisionRuleList.add(new DecisionRule(11,280,1,98.8f));
        decisionRuleList.add(new DecisionRule(12,277,1,98.5f));
        decisionRuleList.add(new DecisionRule(13,157,1,98.2f));
        decisionRuleList.add(new DecisionRule(14,301,1,98.2f));
        decisionRuleList.add(new DecisionRule(15,56,1,98.2f));
        decisionRuleList.add(new DecisionRule(16,244,1,98f));
        decisionRuleList.add(new DecisionRule(17,268,1,97.9f));
        decisionRuleList.add(new DecisionRule(18,243,1,97.9f));
        decisionRuleList.add(new DecisionRule(19,147,1,97.7f));
        decisionRuleList.add(new DecisionRule(20,303,1,97.6f));
        decisionRuleList.add(new DecisionRule(21,72,1,97.5f));
        return decisionRuleList;
    }

    public static List<PermissionIncludedXref> generatePermissionsIncludedXref() {
        List<PermissionIncludedXref> permissionIncludedXrefList = new ArrayList<>();
        permissionIncludedXrefList.add(new PermissionIncludedXref (1,0,12));
        permissionIncludedXrefList.add(new PermissionIncludedXref (2,0,5));
        permissionIncludedXrefList.add(new PermissionIncludedXref (3,0,7));
        permissionIncludedXrefList.add(new PermissionIncludedXref (4,1,8));
        permissionIncludedXrefList.add(new PermissionIncludedXref (5,1,7));
        permissionIncludedXrefList.add(new PermissionIncludedXref (6,2,10));
        permissionIncludedXrefList.add(new PermissionIncludedXref (7,2,12));
        permissionIncludedXrefList.add(new PermissionIncludedXref (8,2,13));
        permissionIncludedXrefList.add(new PermissionIncludedXref (9,2,8));
        permissionIncludedXrefList.add(new PermissionIncludedXref (10,3,11));
        permissionIncludedXrefList.add(new PermissionIncludedXref (11,3,18));
        permissionIncludedXrefList.add(new PermissionIncludedXref (12,3,12));
        permissionIncludedXrefList.add(new PermissionIncludedXref (13,3,16));
        permissionIncludedXrefList.add(new PermissionIncludedXref (14,4,22));
        permissionIncludedXrefList.add(new PermissionIncludedXref (15,4,7));
        permissionIncludedXrefList.add(new PermissionIncludedXref (16,5,12));
        permissionIncludedXrefList.add(new PermissionIncludedXref (17,5,25));
        permissionIncludedXrefList.add(new PermissionIncludedXref (18,5,9));
        permissionIncludedXrefList.add(new PermissionIncludedXref (19,6,5));
        permissionIncludedXrefList.add(new PermissionIncludedXref (20,6,8));
        permissionIncludedXrefList.add(new PermissionIncludedXref (21,6,52));
        permissionIncludedXrefList.add(new PermissionIncludedXref (22,6,26));
        permissionIncludedXrefList.add(new PermissionIncludedXref (23,7,27));
        permissionIncludedXrefList.add(new PermissionIncludedXref (24,7,8));
        permissionIncludedXrefList.add(new PermissionIncludedXref (25,7,26));
        permissionIncludedXrefList.add(new PermissionIncludedXref (26,8,21));
        permissionIncludedXrefList.add(new PermissionIncludedXref (27,8,12));
        permissionIncludedXrefList.add(new PermissionIncludedXref (28,8,16));
        permissionIncludedXrefList.add(new PermissionIncludedXref (29,9,5));
        permissionIncludedXrefList.add(new PermissionIncludedXref (30,9,13));
        permissionIncludedXrefList.add(new PermissionIncludedXref (31,9,8));
        permissionIncludedXrefList.add(new PermissionIncludedXref (32,9,26));
        permissionIncludedXrefList.add(new PermissionIncludedXref (33,10,10));
        permissionIncludedXrefList.add(new PermissionIncludedXref (34,10,7));
        permissionIncludedXrefList.add(new PermissionIncludedXref (35,11,27));
        permissionIncludedXrefList.add(new PermissionIncludedXref (36,11,12));
        permissionIncludedXrefList.add(new PermissionIncludedXref (37,11,15));
        permissionIncludedXrefList.add(new PermissionIncludedXref (38,12,12));
        permissionIncludedXrefList.add(new PermissionIncludedXref (39,12,20));
        permissionIncludedXrefList.add(new PermissionIncludedXref (40,13,33));
        permissionIncludedXrefList.add(new PermissionIncludedXref (41,13,21));
        permissionIncludedXrefList.add(new PermissionIncludedXref (42,13,52));
        permissionIncludedXrefList.add(new PermissionIncludedXref (43,14,33));
        permissionIncludedXrefList.add(new PermissionIncludedXref (44,14,12));
        permissionIncludedXrefList.add(new PermissionIncludedXref (45,14,25));
        permissionIncludedXrefList.add(new PermissionIncludedXref (46,15,13));
        permissionIncludedXrefList.add(new PermissionIncludedXref (47,15,7));
        permissionIncludedXrefList.add(new PermissionIncludedXref (48,16,5));
        permissionIncludedXrefList.add(new PermissionIncludedXref (49,16,10));
        permissionIncludedXrefList.add(new PermissionIncludedXref (50,16,13));
        permissionIncludedXrefList.add(new PermissionIncludedXref (51,16,9));
        permissionIncludedXrefList.add(new PermissionIncludedXref (52,17,24));
        permissionIncludedXrefList.add(new PermissionIncludedXref (53,17,12));
        permissionIncludedXrefList.add(new PermissionIncludedXref (54,18,5));
        permissionIncludedXrefList.add(new PermissionIncludedXref (55,18,12));
        permissionIncludedXrefList.add(new PermissionIncludedXref (56,18,13));
        permissionIncludedXrefList.add(new PermissionIncludedXref (57,18,52));
        permissionIncludedXrefList.add(new PermissionIncludedXref (58,18,26));
        permissionIncludedXrefList.add(new PermissionIncludedXref (59,19,21));
        permissionIncludedXrefList.add(new PermissionIncludedXref (60,19,13));
        permissionIncludedXrefList.add(new PermissionIncludedXref (61,19,7));
        permissionIncludedXrefList.add(new PermissionIncludedXref (62,20,33));
        permissionIncludedXrefList.add(new PermissionIncludedXref (63,20,12));
        permissionIncludedXrefList.add(new PermissionIncludedXref (64,20,40));
        permissionIncludedXrefList.add(new PermissionIncludedXref (65,21,13));
        permissionIncludedXrefList.add(new PermissionIncludedXref (66,21,52));
        permissionIncludedXrefList.add(new PermissionIncludedXref (67,21,7));
        return permissionIncludedXrefList;
    }

    public static List<PermissionExcludedXref> generatePermissionsExcludedXref() {
        List<PermissionExcludedXref> permissionExcludedXrefList = new ArrayList<>();
        permissionExcludedXrefList.add(new PermissionExcludedXref (1,0,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (2,1,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (3,1,9));
        permissionExcludedXrefList.add(new PermissionExcludedXref (4,2,11));
        permissionExcludedXrefList.add(new PermissionExcludedXref (5,2,14));
        permissionExcludedXrefList.add(new PermissionExcludedXref (6,2,15));
        permissionExcludedXrefList.add(new PermissionExcludedXref (7,2,16));
        permissionExcludedXrefList.add(new PermissionExcludedXref (8,3,17));
        permissionExcludedXrefList.add(new PermissionExcludedXref (9,3,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (10,3,19));
        permissionExcludedXrefList.add(new PermissionExcludedXref (11,3,20));
        permissionExcludedXrefList.add(new PermissionExcludedXref (12,4,21));
        permissionExcludedXrefList.add(new PermissionExcludedXref (13,4,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (14,4,23));
        permissionExcludedXrefList.add(new PermissionExcludedXref (15,5,24));
        permissionExcludedXrefList.add(new PermissionExcludedXref (16,5,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (17,5,19));
        permissionExcludedXrefList.add(new PermissionExcludedXref (18,5,26));
        permissionExcludedXrefList.add(new PermissionExcludedXref (19,6,12));
        permissionExcludedXrefList.add(new PermissionExcludedXref (20,6,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (21,6,19));
        permissionExcludedXrefList.add(new PermissionExcludedXref (22,6,14));
        permissionExcludedXrefList.add(new PermissionExcludedXref (23,6,15));
        permissionExcludedXrefList.add(new PermissionExcludedXref (24,7,12));
        permissionExcludedXrefList.add(new PermissionExcludedXref (25,7,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (26,7,19));
        permissionExcludedXrefList.add(new PermissionExcludedXref (27,7,15));
        permissionExcludedXrefList.add(new PermissionExcludedXref (28,8,28));
        permissionExcludedXrefList.add(new PermissionExcludedXref (29,8,29));
        permissionExcludedXrefList.add(new PermissionExcludedXref (30,8,30));
        permissionExcludedXrefList.add(new PermissionExcludedXref (31,8,19));
        permissionExcludedXrefList.add(new PermissionExcludedXref (32,9,29));
        permissionExcludedXrefList.add(new PermissionExcludedXref (33,9,11));
        permissionExcludedXrefList.add(new PermissionExcludedXref (34,9,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (35,9,19));
        permissionExcludedXrefList.add(new PermissionExcludedXref (36,9,14));
        permissionExcludedXrefList.add(new PermissionExcludedXref (37,9,15));
        permissionExcludedXrefList.add(new PermissionExcludedXref (38,9,31));
        permissionExcludedXrefList.add(new PermissionExcludedXref (39,10,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (40,10,15));
        permissionExcludedXrefList.add(new PermissionExcludedXref (41,11,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (42,11,19));
        permissionExcludedXrefList.add(new PermissionExcludedXref (43,12,21));
        permissionExcludedXrefList.add(new PermissionExcludedXref (44,12,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (45,12,19));
        permissionExcludedXrefList.add(new PermissionExcludedXref (46,13,32));
        permissionExcludedXrefList.add(new PermissionExcludedXref (47,13,34));
        permissionExcludedXrefList.add(new PermissionExcludedXref (48,13,29));
        permissionExcludedXrefList.add(new PermissionExcludedXref (49,13,10));
        permissionExcludedXrefList.add(new PermissionExcludedXref (50,13,26));
        permissionExcludedXrefList.add(new PermissionExcludedXref (51,14,27));
        permissionExcludedXrefList.add(new PermissionExcludedXref (52,14,29));
        permissionExcludedXrefList.add(new PermissionExcludedXref (53,14,19));
        permissionExcludedXrefList.add(new PermissionExcludedXref (54,14,26));
        permissionExcludedXrefList.add(new PermissionExcludedXref (55,15,27));
        permissionExcludedXrefList.add(new PermissionExcludedXref (56,15,29));
        permissionExcludedXrefList.add(new PermissionExcludedXref (57,15,17));
        permissionExcludedXrefList.add(new PermissionExcludedXref (58,15,35));
        permissionExcludedXrefList.add(new PermissionExcludedXref (59,15,36));
        permissionExcludedXrefList.add(new PermissionExcludedXref (60,15,37));
        permissionExcludedXrefList.add(new PermissionExcludedXref (61,15,38));
        permissionExcludedXrefList.add(new PermissionExcludedXref (62,15,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (63,16,8));
        permissionExcludedXrefList.add(new PermissionExcludedXref (64,16,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (65,16,19));
        permissionExcludedXrefList.add(new PermissionExcludedXref (66,16,31));
        permissionExcludedXrefList.add(new PermissionExcludedXref (67,17,19));
        permissionExcludedXrefList.add(new PermissionExcludedXref (68,17,15));
        permissionExcludedXrefList.add(new PermissionExcludedXref (69,18,29));
        permissionExcludedXrefList.add(new PermissionExcludedXref (70,18,10));
        permissionExcludedXrefList.add(new PermissionExcludedXref (71,18,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (72,18,39));
        permissionExcludedXrefList.add(new PermissionExcludedXref (73,18,25));
        permissionExcludedXrefList.add(new PermissionExcludedXref (74,18,16));
        permissionExcludedXrefList.add(new PermissionExcludedXref (75,19,32));
        permissionExcludedXrefList.add(new PermissionExcludedXref (76,19,36));
        permissionExcludedXrefList.add(new PermissionExcludedXref (77,19,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (78,20,27));
        permissionExcludedXrefList.add(new PermissionExcludedXref (79,20,17));
        permissionExcludedXrefList.add(new PermissionExcludedXref (80,20,19));
        permissionExcludedXrefList.add(new PermissionExcludedXref (81,20,41));
        permissionExcludedXrefList.add(new PermissionExcludedXref (82,20,26));
        permissionExcludedXrefList.add(new PermissionExcludedXref (83,21,35));
        permissionExcludedXrefList.add(new PermissionExcludedXref (84,21,24));
        permissionExcludedXrefList.add(new PermissionExcludedXref (85,21,6));
        permissionExcludedXrefList.add(new PermissionExcludedXref (86,21,23));
        permissionExcludedXrefList.add(new PermissionExcludedXref (87,21,16));
        return permissionExcludedXrefList;
    }
}
