package com.lulan.shincolle.team;

import com.lulan.shincolle.utility.LogHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Fleet team data.
 * <p>
 * A team = a fleet with one leader (player).
 * Team ally = friendly team; not ally = neutral (not hostile unless banned).
 * Team banned = always hostile team; you can't ally with a banned team.
 * <p>
 * Team ID = player UID (one player = one team).
 */
public class TeamData {

    private int teamID;
    private String teamName;
    private String leaderName;
    private List<Integer> teamBanID;
    private List<Integer> teamAllyID;

    public TeamData() {
        this.teamID = 0;
        this.teamName = "   ";
        this.leaderName = "   ";
        this.teamBanID = new ArrayList<>();
        this.teamAllyID = new ArrayList<>();
    }

    public TeamData(int teamID, String teamName, String leaderName) {
        this.teamID = teamID;
        this.teamName = teamName;
        this.leaderName = leaderName;
        this.teamBanID = new ArrayList<>();
        this.teamAllyID = new ArrayList<>();
    }

    // ========== Getters ==========

    public int getTeamID() {
        return this.teamID;
    }

    public void setTeamID(int id) {
        this.teamID = id;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String name) {
        this.teamName = name;
    }

    public String getTeamLeaderName() {
        return this.leaderName;
    }

    // ========== Setters ==========

    public void setTeamLeaderName(String name) {
        this.leaderName = name;
    }

    public List<Integer> getTeamBannedList() {
        if (this.teamBanID == null) {
            this.teamBanID = new ArrayList<>();
        }
        return this.teamBanID;
    }

    public void setTeamBannedList(List<Integer> list) {
        this.teamBanID = list;
    }

    public List<Integer> getTeamAllyList() {
        if (this.teamAllyID == null) {
            this.teamAllyID = new ArrayList<>();
        }
        return this.teamAllyID;
    }

    public void setTeamAllyList(List<Integer> list) {
        this.teamAllyID = list;
    }

    // ========== Ally management ==========

    /**
     * Add ally — only if not already allied and not banned
     */
    public void addTeamAlly(int id) {
        if (id > 0 && this.teamAllyID != null) {
            if (!this.teamAllyID.contains(id) && !this.teamBanID.contains(id)) {
                this.teamAllyID.add(id);
                LogHelper.debug("team data: add ally: team " + this.teamName + " add " + id);
            }
        }
    }

    /**
     * Remove ally
     */
    public void removeTeamAlly(int id) {
        if (id > 0 && this.teamAllyID != null) {
            if (this.teamAllyID.contains(id)) {
                this.teamAllyID.remove((Integer) id); // remove object, not index
                LogHelper.debug("team data: remove ally: team " + this.teamName + " remove " + id);
            }
        }
    }

    // ========== Ban management ==========

    /**
     * Add banned (hostile) team — only if not already banned and not allied
     */
    public void addTeamBanned(int id) {
        if (id > 0 && this.teamBanID != null) {
            if (!this.teamBanID.contains(id) && !this.teamAllyID.contains(id)) {
                this.teamBanID.add(id);
                LogHelper.debug("team data: add banned: team " + this.teamName + " add " + id);
            }
        }
    }

    /**
     * Remove banned (hostile) team
     */
    public void removeTeamBanned(int id) {
        if (id > 0 && this.teamBanID != null) {
            if (this.teamBanID.contains(id)) {
                this.teamBanID.remove((Integer) id); // remove object, not index
                LogHelper.debug("team data: remove banned: team " + this.teamName + " remove " + id);
            }
        }
    }

    // ========== Checks ==========

    /**
     * Check if team is in ally list. ID 0 = always friendly.
     */
    public boolean isTeamAlly(int id) {
        if (id == 0)
            return true;
        if (id > 0 && this.teamAllyID != null) {
            return this.teamAllyID.contains(id);
        }
        return false;
    }

    /**
     * Check if team is in ban list. ID 0 = always friendly (never banned).
     */
    public boolean isTeamBanned(int id) {
        if (id == 0)
            return false;
        if (id > 0 && this.teamBanID != null) {
            return this.teamBanID.contains(id);
        }
        return false;
    }
}
