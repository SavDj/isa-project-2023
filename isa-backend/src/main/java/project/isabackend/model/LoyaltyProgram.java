package project.isabackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "LoyaltyPrograms")
public class LoyaltyProgram {
    @Id
    @SequenceGenerator(name = "LoyaltyProgramIdGenerator", sequenceName = "LoyaltyIdsSequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LoyaltyIdGenerator")
    @Column(name = "id")
    private long id;

    @Column(name = "points_per_purchase")
    private int pointsPerPurchase;

    @Column(name = "penalty_point_deduction")
    private int penaltyPointDeduction;

    @Column(name = "silver_threshold")
    private int silverThreshold;

    @Column(name = "gold_threshold")
    private int goldThreshold;

    public LoyaltyProgram() {
    }

    public LoyaltyProgram(long id, int pointsPerPurchase, int penaltyPointDeduction, int silverThreshold, int goldThreshold) {
        this.id = id;
        this.pointsPerPurchase = pointsPerPurchase;
        this.penaltyPointDeduction = penaltyPointDeduction;
        this.silverThreshold = silverThreshold;
        this.goldThreshold = goldThreshold;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPointsPerPurchase() {
        return pointsPerPurchase;
    }

    public void setPointsPerPurchase(int pointsPerPurchase) {
        this.pointsPerPurchase = pointsPerPurchase;
    }

    public int getPenaltyPointDeduction() {
        return penaltyPointDeduction;
    }

    public void setPenaltyPointDeduction(int penaltyPointDeduction) {
        this.penaltyPointDeduction = penaltyPointDeduction;
    }

    public int getSilverThreshold() {
        return silverThreshold;
    }

    public void setSilverThreshold(int silverThreshold) {
        this.silverThreshold = silverThreshold;
    }

    public int getGoldThreshold() {
        return goldThreshold;
    }

    public void setGoldThreshold(int goldThreshold) {
        this.goldThreshold = goldThreshold;
    }
}
