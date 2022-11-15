package com.implingsaver;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.*;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.inventoryviewer.InventoryViewerPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static net.runelite.api.ItemID.*;

@Slf4j
@PluginDescriptor(
	name = "ImplingSaver"
)
public class ImplingSaverPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ImplingSaverConfig config;

	public ArrayList easyClues = new ArrayList(Arrays.asList(
			CLUE_SCROLL_EASY,
			CLUE_SCROLL_EASY_2678,
			CLUE_SCROLL_EASY_2679,
			CLUE_SCROLL_EASY_2680,
			CLUE_SCROLL_EASY_2681,
			CLUE_SCROLL_EASY_2682,
			CLUE_SCROLL_EASY_2683,
			CLUE_SCROLL_EASY_2684,
			CLUE_SCROLL_EASY_2685,
			CLUE_SCROLL_EASY_2686,
			CLUE_SCROLL_EASY_2687,
			CLUE_SCROLL_EASY_2688,
			CLUE_SCROLL_EASY_2689,
			CLUE_SCROLL_EASY_2690,
			CLUE_SCROLL_EASY_2691,
			CLUE_SCROLL_EASY_2692,
			CLUE_SCROLL_EASY_2693,
			CLUE_SCROLL_EASY_2694,
			CLUE_SCROLL_EASY_2695,
			CLUE_SCROLL_EASY_2696,
			CLUE_SCROLL_EASY_2697,
			CLUE_SCROLL_EASY_2698,
			CLUE_SCROLL_EASY_2699,
			CLUE_SCROLL_EASY_2700,
			CLUE_SCROLL_EASY_2701,
			CLUE_SCROLL_EASY_2702,
			CLUE_SCROLL_EASY_2703,
			CLUE_SCROLL_EASY_2704,
			CLUE_SCROLL_EASY_2705,
			CLUE_SCROLL_EASY_2706,
			CLUE_SCROLL_EASY_2707,
			CLUE_SCROLL_EASY_2708,
			CLUE_SCROLL_EASY_2709,
			CLUE_SCROLL_EASY_2710,
			CLUE_SCROLL_EASY_2711,
			CLUE_SCROLL_EASY_2712,
			CLUE_SCROLL_EASY_2713,
			CLUE_SCROLL_EASY_2716,
			CLUE_SCROLL_EASY_2719,
			CLUE_SCROLL_EASY_3490,
			CLUE_SCROLL_EASY_3491,
			CLUE_SCROLL_EASY_3492,
			CLUE_SCROLL_EASY_3493,
			CLUE_SCROLL_EASY_3494,
			CLUE_SCROLL_EASY_3495,
			CLUE_SCROLL_EASY_3496,
			CLUE_SCROLL_EASY_3497,
			CLUE_SCROLL_EASY_3498,
			CLUE_SCROLL_EASY_3499,
			CLUE_SCROLL_EASY_3500,
			CLUE_SCROLL_EASY_3501,
			CLUE_SCROLL_EASY_3502,
			CLUE_SCROLL_EASY_3503,
			CLUE_SCROLL_EASY_3504,
			CLUE_SCROLL_EASY_3505,
			CLUE_SCROLL_EASY_3506,
			CLUE_SCROLL_EASY_3507,
			CLUE_SCROLL_EASY_3508,
			CLUE_SCROLL_EASY_3509,
			CLUE_SCROLL_EASY_3510,
			CLUE_SCROLL_EASY_3512,
			CLUE_SCROLL_EASY_3513,
			CLUE_SCROLL_EASY_3514,
			CLUE_SCROLL_EASY_3515,
			CLUE_SCROLL_EASY_3516,
			CLUE_SCROLL_EASY_3518,
			CLUE_SCROLL_EASY_7236,
			CLUE_SCROLL_EASY_7238,
			CLUE_SCROLL_EASY_10180,
			CLUE_SCROLL_EASY_10182,
			CLUE_SCROLL_EASY_10184,
			CLUE_SCROLL_EASY_10186,
			CLUE_SCROLL_EASY_10188,
			CLUE_SCROLL_EASY_10190,
			CLUE_SCROLL_EASY_10192,
			CLUE_SCROLL_EASY_10194,
			CLUE_SCROLL_EASY_10196,
			CLUE_SCROLL_EASY_10198,
			CLUE_SCROLL_EASY_10200,
			CLUE_SCROLL_EASY_10202,
			CLUE_SCROLL_EASY_10204,
			CLUE_SCROLL_EASY_10206,
			CLUE_SCROLL_EASY_10208,
			CLUE_SCROLL_EASY_10210,
			CLUE_SCROLL_EASY_10212,
			CLUE_SCROLL_EASY_10214,
			CLUE_SCROLL_EASY_10216,
			CLUE_SCROLL_EASY_10218,
			CLUE_SCROLL_EASY_10220,
			CLUE_SCROLL_EASY_10222,
			CLUE_SCROLL_EASY_10224,
			CLUE_SCROLL_EASY_10226,
			CLUE_SCROLL_EASY_10228,
			CLUE_SCROLL_EASY_10230,
			CLUE_SCROLL_EASY_10232,
			CLUE_SCROLL_EASY_12162,
			CLUE_SCROLL_EASY_12164,
			CLUE_SCROLL_EASY_12166,
			CLUE_SCROLL_EASY_12167,
			CLUE_SCROLL_EASY_12168,
			CLUE_SCROLL_EASY_12169,
			CLUE_SCROLL_EASY_12170,
			CLUE_SCROLL_EASY_12172,
			CLUE_SCROLL_EASY_12173,
			CLUE_SCROLL_EASY_12174,
			CLUE_SCROLL_EASY_12175,
			CLUE_SCROLL_EASY_12176,
			CLUE_SCROLL_EASY_12177,
			CLUE_SCROLL_EASY_12178,
			CLUE_SCROLL_EASY_12179,
			CLUE_SCROLL_EASY_12181,
			CLUE_SCROLL_EASY_12182,
			CLUE_SCROLL_EASY_12183,
			CLUE_SCROLL_EASY_12184,
			CLUE_SCROLL_EASY_12185,
			CLUE_SCROLL_EASY_12186,
			CLUE_SCROLL_EASY_12187,
			CLUE_SCROLL_EASY_12188,
			CLUE_SCROLL_EASY_12189,
			CLUE_SCROLL_EASY_12190,
			CLUE_SCROLL_EASY_12191,
			CLUE_SCROLL_EASY_12192,
			CLUE_SCROLL_EASY_19814,
			CLUE_SCROLL_EASY_19816,
			CLUE_SCROLL_EASY_19817,
			CLUE_SCROLL_EASY_19818,
			CLUE_SCROLL_EASY_19819,
			CLUE_SCROLL_EASY_19820,
			CLUE_SCROLL_EASY_19821,
			CLUE_SCROLL_EASY_19822,
			CLUE_SCROLL_EASY_19823,
			CLUE_SCROLL_EASY_19824,
			CLUE_SCROLL_EASY_19825,
			CLUE_SCROLL_EASY_19826,
			CLUE_SCROLL_EASY_19828,
			CLUE_SCROLL_EASY_19829,
			CLUE_SCROLL_EASY_19830,
			CLUE_SCROLL_EASY_19831,
			CLUE_SCROLL_EASY_19833,
			CLUE_SCROLL_EASY_22001,
			CLUE_SCROLL_EASY_23149,
			CLUE_SCROLL_EASY_23150,
			CLUE_SCROLL_EASY_23151,
			CLUE_SCROLL_EASY_23152,
			CLUE_SCROLL_EASY_23153,
			CLUE_SCROLL_EASY_23154,
			CLUE_SCROLL_EASY_23155,
			CLUE_SCROLL_EASY_23156,
			CLUE_SCROLL_EASY_23157,
			CLUE_SCROLL_EASY_23158,
			CLUE_SCROLL_EASY_23159,
			CLUE_SCROLL_EASY_23160,
			CLUE_SCROLL_EASY_23161,
			CLUE_SCROLL_EASY_23162,
			CLUE_SCROLL_EASY_23163,
			CLUE_SCROLL_EASY_23164,
			CLUE_SCROLL_EASY_23165,
			CLUE_SCROLL_EASY_23166,
			CLUE_SCROLL_EASY_25788,
			CLUE_SCROLL_EASY_25789
	));

	public ArrayList mediumClues = new ArrayList(Arrays.asList(
			CLUE_SCROLL_MEDIUM,
			CLUE_SCROLL_MEDIUM_2803,
			CLUE_SCROLL_MEDIUM_2805,
			CLUE_SCROLL_MEDIUM_2807,
			CLUE_SCROLL_MEDIUM_2809,
			CLUE_SCROLL_MEDIUM_2811,
			CLUE_SCROLL_MEDIUM_2813,
			CLUE_SCROLL_MEDIUM_2815,
			CLUE_SCROLL_MEDIUM_2817,
			CLUE_SCROLL_MEDIUM_2819,
			CLUE_SCROLL_MEDIUM_2821,
			CLUE_SCROLL_MEDIUM_2823,
			CLUE_SCROLL_MEDIUM_2825,
			CLUE_SCROLL_MEDIUM_2827,
			CLUE_SCROLL_MEDIUM_2829,
			CLUE_SCROLL_MEDIUM_2831,
			CLUE_SCROLL_MEDIUM_2833,
			CLUE_SCROLL_MEDIUM_2835,
			CLUE_SCROLL_MEDIUM_2837,
			CLUE_SCROLL_MEDIUM_2839,
			CLUE_SCROLL_MEDIUM_2841,
			CLUE_SCROLL_MEDIUM_2843,
			CLUE_SCROLL_MEDIUM_2845,
			CLUE_SCROLL_MEDIUM_2847,
			CLUE_SCROLL_MEDIUM_2848,
			CLUE_SCROLL_MEDIUM_2849,
			CLUE_SCROLL_MEDIUM_2851,
			CLUE_SCROLL_MEDIUM_2853,
			CLUE_SCROLL_MEDIUM_2855,
			CLUE_SCROLL_MEDIUM_2856,
			CLUE_SCROLL_MEDIUM_2857,
			CLUE_SCROLL_MEDIUM_2858,
			CLUE_SCROLL_MEDIUM_3582,
			CLUE_SCROLL_MEDIUM_3584,
			CLUE_SCROLL_MEDIUM_3586,
			CLUE_SCROLL_MEDIUM_3588,
			CLUE_SCROLL_MEDIUM_3590,
			CLUE_SCROLL_MEDIUM_3592,
			CLUE_SCROLL_MEDIUM_3594,
			CLUE_SCROLL_MEDIUM_3596,
			CLUE_SCROLL_MEDIUM_3598,
			CLUE_SCROLL_MEDIUM_3599,
			CLUE_SCROLL_MEDIUM_3601,
			CLUE_SCROLL_MEDIUM_3602,
			CLUE_SCROLL_MEDIUM_3604,
			CLUE_SCROLL_MEDIUM_3605,
			CLUE_SCROLL_MEDIUM_3607,
			CLUE_SCROLL_MEDIUM_3609,
			CLUE_SCROLL_MEDIUM_3610,
			CLUE_SCROLL_MEDIUM_3611,
			CLUE_SCROLL_MEDIUM_3612,
			CLUE_SCROLL_MEDIUM_3613,
			CLUE_SCROLL_MEDIUM_3614,
			CLUE_SCROLL_MEDIUM_3615,
			CLUE_SCROLL_MEDIUM_3616,
			CLUE_SCROLL_MEDIUM_3617,
			CLUE_SCROLL_MEDIUM_3618,
			CLUE_SCROLL_MEDIUM_7274,
			CLUE_SCROLL_MEDIUM_7276,
			CLUE_SCROLL_MEDIUM_7278,
			CLUE_SCROLL_MEDIUM_7280,
			CLUE_SCROLL_MEDIUM_7282,
			CLUE_SCROLL_MEDIUM_7284,
			CLUE_SCROLL_MEDIUM_7286,
			CLUE_SCROLL_MEDIUM_7288,
			CLUE_SCROLL_MEDIUM_7290,
			CLUE_SCROLL_MEDIUM_7292,
			CLUE_SCROLL_MEDIUM_7294,
			CLUE_SCROLL_MEDIUM_7296,
			CLUE_SCROLL_MEDIUM_7298,
			CLUE_SCROLL_MEDIUM_7300,
			CLUE_SCROLL_MEDIUM_7301,
			CLUE_SCROLL_MEDIUM_7303,
			CLUE_SCROLL_MEDIUM_7304,
			CLUE_SCROLL_MEDIUM_7305,
			CLUE_SCROLL_MEDIUM_7307,
			CLUE_SCROLL_MEDIUM_7309,
			CLUE_SCROLL_MEDIUM_7311,
			CLUE_SCROLL_MEDIUM_7313,
			CLUE_SCROLL_MEDIUM_7315,
			CLUE_SCROLL_MEDIUM_7317,
			CLUE_SCROLL_MEDIUM_10254,
			CLUE_SCROLL_MEDIUM_10256,
			CLUE_SCROLL_MEDIUM_10258,
			CLUE_SCROLL_MEDIUM_10260,
			CLUE_SCROLL_MEDIUM_10262,
			CLUE_SCROLL_MEDIUM_10264,
			CLUE_SCROLL_MEDIUM_10266,
			CLUE_SCROLL_MEDIUM_10268,
			CLUE_SCROLL_MEDIUM_10270,
			CLUE_SCROLL_MEDIUM_10272,
			CLUE_SCROLL_MEDIUM_10274,
			CLUE_SCROLL_MEDIUM_10276,
			CLUE_SCROLL_MEDIUM_10278,
			CLUE_SCROLL_MEDIUM_12021,
			CLUE_SCROLL_MEDIUM_12023,
			CLUE_SCROLL_MEDIUM_12025,
			CLUE_SCROLL_MEDIUM_12027,
			CLUE_SCROLL_MEDIUM_12029,
			CLUE_SCROLL_MEDIUM_12031,
			CLUE_SCROLL_MEDIUM_12033,
			CLUE_SCROLL_MEDIUM_12035,
			CLUE_SCROLL_MEDIUM_12037,
			CLUE_SCROLL_MEDIUM_12039,
			CLUE_SCROLL_MEDIUM_12041,
			CLUE_SCROLL_MEDIUM_12043,
			CLUE_SCROLL_MEDIUM_12045,
			CLUE_SCROLL_MEDIUM_12047,
			CLUE_SCROLL_MEDIUM_12049,
			CLUE_SCROLL_MEDIUM_12051,
			CLUE_SCROLL_MEDIUM_12053,
			CLUE_SCROLL_MEDIUM_12055,
			CLUE_SCROLL_MEDIUM_12057,
			CLUE_SCROLL_MEDIUM_12059,
			CLUE_SCROLL_MEDIUM_12061,
			CLUE_SCROLL_MEDIUM_12063,
			CLUE_SCROLL_MEDIUM_12065,
			CLUE_SCROLL_MEDIUM_12067,
			CLUE_SCROLL_MEDIUM_12069,
			CLUE_SCROLL_MEDIUM_12071,
			CLUE_SCROLL_MEDIUM_19734,
			CLUE_SCROLL_MEDIUM_19736,
			CLUE_SCROLL_MEDIUM_19738,
			CLUE_SCROLL_MEDIUM_19740,
			CLUE_SCROLL_MEDIUM_19742,
			CLUE_SCROLL_MEDIUM_19744,
			CLUE_SCROLL_MEDIUM_19746,
			CLUE_SCROLL_MEDIUM_19748,
			CLUE_SCROLL_MEDIUM_19750,
			CLUE_SCROLL_MEDIUM_19752,
			CLUE_SCROLL_MEDIUM_19754,
			CLUE_SCROLL_MEDIUM_19756,
			CLUE_SCROLL_MEDIUM_19758,
			CLUE_SCROLL_MEDIUM_19760,
			CLUE_SCROLL_MEDIUM_19762,
			CLUE_SCROLL_MEDIUM_19764,
			CLUE_SCROLL_MEDIUM_19766,
			CLUE_SCROLL_MEDIUM_19768,
			CLUE_SCROLL_MEDIUM_19770,
			CLUE_SCROLL_MEDIUM_19772,
			CLUE_SCROLL_MEDIUM_19774,
			CLUE_SCROLL_MEDIUM_19776,
			CLUE_SCROLL_MEDIUM_19778,
			CLUE_SCROLL_MEDIUM_19780,
			CLUE_SCROLL_MEDIUM_23046,
			CLUE_SCROLL_MEDIUM_23131,
			CLUE_SCROLL_MEDIUM_23133,
			CLUE_SCROLL_MEDIUM_23135,
			CLUE_SCROLL_MEDIUM_23136,
			CLUE_SCROLL_MEDIUM_23137,
			CLUE_SCROLL_MEDIUM_23138,
			CLUE_SCROLL_MEDIUM_23139,
			CLUE_SCROLL_MEDIUM_23140,
			CLUE_SCROLL_MEDIUM_23141,
			CLUE_SCROLL_MEDIUM_23142,
			CLUE_SCROLL_MEDIUM_23143,
			CLUE_SCROLL_MEDIUM_25783,
			CLUE_SCROLL_MEDIUM_25784
	));

	public ArrayList hardClues = new ArrayList(Arrays.asList(
			CLUE_SCROLL_HARD,
			CLUE_SCROLL_HARD_2723,
			CLUE_SCROLL_HARD_2725,
			CLUE_SCROLL_HARD_2727,
			CLUE_SCROLL_HARD_2729,
			CLUE_SCROLL_HARD_2731,
			CLUE_SCROLL_HARD_2733,
			CLUE_SCROLL_HARD_2735,
			CLUE_SCROLL_HARD_2737,
			CLUE_SCROLL_HARD_2739,
			CLUE_SCROLL_HARD_2741,
			CLUE_SCROLL_HARD_2743,
			CLUE_SCROLL_HARD_2745,
			CLUE_SCROLL_HARD_2747,
			CLUE_SCROLL_HARD_2773,
			CLUE_SCROLL_HARD_2774,
			CLUE_SCROLL_HARD_2776,
			CLUE_SCROLL_HARD_2778,
			CLUE_SCROLL_HARD_2780,
			CLUE_SCROLL_HARD_2782,
			CLUE_SCROLL_HARD_2783,
			CLUE_SCROLL_HARD_2785,
			CLUE_SCROLL_HARD_2786,
			CLUE_SCROLL_HARD_2788,
			CLUE_SCROLL_HARD_2790,
			CLUE_SCROLL_HARD_2792,
			CLUE_SCROLL_HARD_2793,
			CLUE_SCROLL_HARD_2794,
			CLUE_SCROLL_HARD_2796,
			CLUE_SCROLL_HARD_2797,
			CLUE_SCROLL_HARD_2799,
			CLUE_SCROLL_HARD_3520,
			CLUE_SCROLL_HARD_3522,
			CLUE_SCROLL_HARD_3524,
			CLUE_SCROLL_HARD_3525,
			CLUE_SCROLL_HARD_3526,
			CLUE_SCROLL_HARD_3528,
			CLUE_SCROLL_HARD_3530,
			CLUE_SCROLL_HARD_3532,
			CLUE_SCROLL_HARD_3534,
			CLUE_SCROLL_HARD_3536,
			CLUE_SCROLL_HARD_3538,
			CLUE_SCROLL_HARD_3540,
			CLUE_SCROLL_HARD_3542,
			CLUE_SCROLL_HARD_3544,
			CLUE_SCROLL_HARD_3546,
			CLUE_SCROLL_HARD_3548,
			CLUE_SCROLL_HARD_3550,
			CLUE_SCROLL_HARD_3552,
			CLUE_SCROLL_HARD_3554,
			CLUE_SCROLL_HARD_3556,
			CLUE_SCROLL_HARD_3558,
			CLUE_SCROLL_HARD_3560,
			CLUE_SCROLL_HARD_3562,
			CLUE_SCROLL_HARD_3564,
			CLUE_SCROLL_HARD_3566,
			CLUE_SCROLL_HARD_3568,
			CLUE_SCROLL_HARD_3570,
			CLUE_SCROLL_HARD_3572,
			CLUE_SCROLL_HARD_3573,
			CLUE_SCROLL_HARD_3574,
			CLUE_SCROLL_HARD_3575,
			CLUE_SCROLL_HARD_3577,
			CLUE_SCROLL_HARD_3579,
			CLUE_SCROLL_HARD_3580,
			CLUE_SCROLL_HARD_7239,
			CLUE_SCROLL_HARD_7241,
			CLUE_SCROLL_HARD_7243,
			CLUE_SCROLL_HARD_7245,
			CLUE_SCROLL_HARD_7247,
			CLUE_SCROLL_HARD_7248,
			CLUE_SCROLL_HARD_7249,
			CLUE_SCROLL_HARD_7250,
			CLUE_SCROLL_HARD_7251,
			CLUE_SCROLL_HARD_7252,
			CLUE_SCROLL_HARD_7253,
			CLUE_SCROLL_HARD_7254,
			CLUE_SCROLL_HARD_7255,
			CLUE_SCROLL_HARD_7256,
			CLUE_SCROLL_HARD_7258,
			CLUE_SCROLL_HARD_7260,
			CLUE_SCROLL_HARD_7262,
			CLUE_SCROLL_HARD_7264,
			CLUE_SCROLL_HARD_7266,
			CLUE_SCROLL_HARD_7268,
			CLUE_SCROLL_HARD_7270,
			CLUE_SCROLL_HARD_7272,
			CLUE_SCROLL_HARD_10234,
			CLUE_SCROLL_HARD_10236,
			CLUE_SCROLL_HARD_10238,
			CLUE_SCROLL_HARD_10240,
			CLUE_SCROLL_HARD_10242,
			CLUE_SCROLL_HARD_10244,
			CLUE_SCROLL_HARD_10246,
			CLUE_SCROLL_HARD_10248,
			CLUE_SCROLL_HARD_10250,
			CLUE_SCROLL_HARD_10252,
			CLUE_SCROLL_HARD_12542,
			CLUE_SCROLL_HARD_12544,
			CLUE_SCROLL_HARD_12546,
			CLUE_SCROLL_HARD_12548,
			CLUE_SCROLL_HARD_12550,
			CLUE_SCROLL_HARD_12552,
			CLUE_SCROLL_HARD_12554,
			CLUE_SCROLL_HARD_12556,
			CLUE_SCROLL_HARD_12558,
			CLUE_SCROLL_HARD_12560,
			CLUE_SCROLL_HARD_12562,
			CLUE_SCROLL_HARD_12564,
			CLUE_SCROLL_HARD_12566,
			CLUE_SCROLL_HARD_12568,
			CLUE_SCROLL_HARD_12570,
			CLUE_SCROLL_HARD_12572,
			CLUE_SCROLL_HARD_12574,
			CLUE_SCROLL_HARD_12576,
			CLUE_SCROLL_HARD_12578,
			CLUE_SCROLL_HARD_12581,
			CLUE_SCROLL_HARD_12584,
			CLUE_SCROLL_HARD_12587,
			CLUE_SCROLL_HARD_12590,
			CLUE_SCROLL_HARD_19840,
			CLUE_SCROLL_HARD_19842,
			CLUE_SCROLL_HARD_19844,
			CLUE_SCROLL_HARD_19846,
			CLUE_SCROLL_HARD_19848,
			CLUE_SCROLL_HARD_19850,
			CLUE_SCROLL_HARD_19852,
			CLUE_SCROLL_HARD_19853,
			CLUE_SCROLL_HARD_19854,
			CLUE_SCROLL_HARD_19856,
			CLUE_SCROLL_HARD_19857,
			CLUE_SCROLL_HARD_19858,
			CLUE_SCROLL_HARD_19860,
			CLUE_SCROLL_HARD_19862,
			CLUE_SCROLL_HARD_19864,
			CLUE_SCROLL_HARD_19866,
			CLUE_SCROLL_HARD_19868,
			CLUE_SCROLL_HARD_19870,
			CLUE_SCROLL_HARD_19872,
			CLUE_SCROLL_HARD_19874,
			CLUE_SCROLL_HARD_19876,
			CLUE_SCROLL_HARD_19878,
			CLUE_SCROLL_HARD_19880,
			CLUE_SCROLL_HARD_19882,
			CLUE_SCROLL_HARD_19884,
			CLUE_SCROLL_HARD_19886,
			CLUE_SCROLL_HARD_19888,
			CLUE_SCROLL_HARD_19890,
			CLUE_SCROLL_HARD_19892,
			CLUE_SCROLL_HARD_19894,
			CLUE_SCROLL_HARD_19896,
			CLUE_SCROLL_HARD_19898,
			CLUE_SCROLL_HARD_19900,
			CLUE_SCROLL_HARD_19902,
			CLUE_SCROLL_HARD_19904,
			CLUE_SCROLL_HARD_19906,
			CLUE_SCROLL_HARD_19908,
			CLUE_SCROLL_HARD_19910,
			CLUE_SCROLL_HARD_21526,
			CLUE_SCROLL_HARD_21527,
			CLUE_SCROLL_HARD_23045,
			CLUE_SCROLL_HARD_23167,
			CLUE_SCROLL_HARD_23168,
			CLUE_SCROLL_HARD_23169,
			CLUE_SCROLL_HARD_23170,
			CLUE_SCROLL_HARD_23172,
			CLUE_SCROLL_HARD_23174,
			CLUE_SCROLL_HARD_23175,
			CLUE_SCROLL_HARD_23176,
			CLUE_SCROLL_HARD_23177,
			CLUE_SCROLL_HARD_23178,
			CLUE_SCROLL_HARD_23179,
			CLUE_SCROLL_HARD_23180,
			CLUE_SCROLL_HARD_23181,
			CLUE_SCROLL_HARD_24493,
			CLUE_SCROLL_HARD_25790,
			CLUE_SCROLL_HARD_25791,
			CLUE_SCROLL_HARD_25792,
			CLUE_SCROLL_HARD_26566
	));

	public ArrayList eliteClues = new ArrayList(Arrays.asList(
			CLUE_SCROLL_ELITE,
			CLUE_SCROLL_ELITE_12074,
			CLUE_SCROLL_ELITE_12075,
			CLUE_SCROLL_ELITE_12076,
			CLUE_SCROLL_ELITE_12077,
			CLUE_SCROLL_ELITE_12078,
			CLUE_SCROLL_ELITE_12079,
			CLUE_SCROLL_ELITE_12080,
			CLUE_SCROLL_ELITE_12081,
			CLUE_SCROLL_ELITE_12082,
			CLUE_SCROLL_ELITE_12083,
			CLUE_SCROLL_ELITE_12085,
			CLUE_SCROLL_ELITE_12087,
			CLUE_SCROLL_ELITE_12088,
			CLUE_SCROLL_ELITE_12089,
			CLUE_SCROLL_ELITE_12090,
			CLUE_SCROLL_ELITE_12091,
			CLUE_SCROLL_ELITE_12092,
			CLUE_SCROLL_ELITE_12093,
			CLUE_SCROLL_ELITE_12094,
			CLUE_SCROLL_ELITE_12095,
			CLUE_SCROLL_ELITE_12096,
			CLUE_SCROLL_ELITE_12097,
			CLUE_SCROLL_ELITE_12098,
			CLUE_SCROLL_ELITE_12099,
			CLUE_SCROLL_ELITE_12100,
			CLUE_SCROLL_ELITE_12101,
			CLUE_SCROLL_ELITE_12102,
			CLUE_SCROLL_ELITE_12103,
			CLUE_SCROLL_ELITE_12104,
			CLUE_SCROLL_ELITE_12105,
			CLUE_SCROLL_ELITE_12106,
			CLUE_SCROLL_ELITE_12107,
			CLUE_SCROLL_ELITE_12108,
			CLUE_SCROLL_ELITE_12109,
			CLUE_SCROLL_ELITE_12110,
			CLUE_SCROLL_ELITE_12111,
			CLUE_SCROLL_ELITE_12113,
			CLUE_SCROLL_ELITE_12114,
			CLUE_SCROLL_ELITE_12115,
			CLUE_SCROLL_ELITE_12116,
			CLUE_SCROLL_ELITE_12117,
			CLUE_SCROLL_ELITE_12118,
			CLUE_SCROLL_ELITE_12119,
			CLUE_SCROLL_ELITE_12120,
			CLUE_SCROLL_ELITE_12121,
			CLUE_SCROLL_ELITE_12122,
			CLUE_SCROLL_ELITE_12123,
			CLUE_SCROLL_ELITE_12124,
			CLUE_SCROLL_ELITE_12125,
			CLUE_SCROLL_ELITE_12126,
			CLUE_SCROLL_ELITE_12127,
			CLUE_SCROLL_ELITE_12130,
			CLUE_SCROLL_ELITE_12132,
			CLUE_SCROLL_ELITE_12133,
			CLUE_SCROLL_ELITE_12134,
			CLUE_SCROLL_ELITE_12135,
			CLUE_SCROLL_ELITE_12136,
			CLUE_SCROLL_ELITE_12137,
			CLUE_SCROLL_ELITE_12138,
			CLUE_SCROLL_ELITE_12140,
			CLUE_SCROLL_ELITE_12141,
			CLUE_SCROLL_ELITE_12142,
			CLUE_SCROLL_ELITE_12143,
			CLUE_SCROLL_ELITE_12144,
			CLUE_SCROLL_ELITE_12145,
			CLUE_SCROLL_ELITE_12146,
			CLUE_SCROLL_ELITE_12147,
			CLUE_SCROLL_ELITE_12148,
			CLUE_SCROLL_ELITE_12149,
			CLUE_SCROLL_ELITE_12150,
			CLUE_SCROLL_ELITE_12151,
			CLUE_SCROLL_ELITE_12152,
			CLUE_SCROLL_ELITE_12153,
			CLUE_SCROLL_ELITE_12154,
			CLUE_SCROLL_ELITE_12155,
			CLUE_SCROLL_ELITE_12156,
			CLUE_SCROLL_ELITE_12157,
			CLUE_SCROLL_ELITE_12158,
			CLUE_SCROLL_ELITE_12159,
			CLUE_SCROLL_ELITE_19782,
			CLUE_SCROLL_ELITE_19783,
			CLUE_SCROLL_ELITE_19784,
			CLUE_SCROLL_ELITE_19785,
			CLUE_SCROLL_ELITE_19786,
			CLUE_SCROLL_ELITE_19787,
			CLUE_SCROLL_ELITE_19788,
			CLUE_SCROLL_ELITE_19789,
			CLUE_SCROLL_ELITE_19790,
			CLUE_SCROLL_ELITE_19791,
			CLUE_SCROLL_ELITE_19792,
			CLUE_SCROLL_ELITE_19793,
			CLUE_SCROLL_ELITE_19794,
			CLUE_SCROLL_ELITE_19795,
			CLUE_SCROLL_ELITE_19796,
			CLUE_SCROLL_ELITE_19797,
			CLUE_SCROLL_ELITE_19798,
			CLUE_SCROLL_ELITE_19799,
			CLUE_SCROLL_ELITE_19800,
			CLUE_SCROLL_ELITE_19801,
			CLUE_SCROLL_ELITE_19802,
			CLUE_SCROLL_ELITE_19803,
			CLUE_SCROLL_ELITE_19804,
			CLUE_SCROLL_ELITE_19805,
			CLUE_SCROLL_ELITE_19806,
			CLUE_SCROLL_ELITE_19807,
			CLUE_SCROLL_ELITE_19808,
			CLUE_SCROLL_ELITE_19809,
			CLUE_SCROLL_ELITE_19810,
			CLUE_SCROLL_ELITE_19811,
			CLUE_SCROLL_ELITE_19813,
			CLUE_SCROLL_ELITE_21524,
			CLUE_SCROLL_ELITE_21525,
			CLUE_SCROLL_ELITE_22000,
			CLUE_SCROLL_ELITE_23144,
			CLUE_SCROLL_ELITE_23145,
			CLUE_SCROLL_ELITE_23146,
			CLUE_SCROLL_ELITE_23147,
			CLUE_SCROLL_ELITE_23148,
			CLUE_SCROLL_ELITE_23770,
			CLUE_SCROLL_ELITE_24253,
			CLUE_SCROLL_ELITE_24773,
			CLUE_SCROLL_ELITE_25498,
			CLUE_SCROLL_ELITE_25499,
			CLUE_SCROLL_ELITE_25786,
			CLUE_SCROLL_ELITE_25787,
			CLUE_SCROLL_ELITE_26943,
			CLUE_SCROLL_ELITE_26944
	));

	private boolean containBeginnerClue;
	private boolean easyClueScan = false;
	private boolean containEasyClue;
	private boolean mediumClueScan = false;
	private boolean containMediumClue;
	private boolean hardClueScan = false;
	private boolean containHardClue;
	private boolean eliteClueScan = false;
	private boolean containEliteClue;

	@Subscribe
	public void onClientTick(ClientTick clientTick) {
		removeOpenOption();
		resetContains();

	}

	@Provides
	ImplingSaverConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ImplingSaverConfig.class);
	}

	/**
	 * Remove the open option from impling jars when the
	 * corresponding clue is within inventory
	 */
	private void removeOpenOption() {
		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);
		if (inventory == null)
			return;

		for (Widget inventoryItem : Objects.requireNonNull(inventory.getChildren())) {
			if(easyClues.contains(inventoryItem.getItemId())) {
				easyClueScan = true;
			}
			else if(mediumClues.contains(inventoryItem.getItemId())) {
				mediumClueScan = true;
			}
			else if(hardClues.contains(inventoryItem.getItemId())) {
				hardClueScan = true;
			}
			else if(eliteClues.contains(inventoryItem.getItemId())) {
				eliteClueScan = true;
			}
		}

		containEasyClue = easyClueScan ? (containEasyClue = true) : (containEasyClue = false);
		containMediumClue = mediumClueScan ? (containMediumClue = true) : (containMediumClue = false);
		containHardClue = hardClueScan ? (containHardClue = true) : (containHardClue = false);
		containEliteClue = eliteClueScan ? (containEliteClue = true) : (containEliteClue = false);

		if(config.easyMode() && containEasyClue) {
			for (Widget inventoryItem : Objects.requireNonNull(inventory.getChildren())) {
				int id = inventoryItem.getItemId();
				if (id == YOUNG_IMPLING_JAR || id == GOURMET_IMPLING_JAR) {
					inventoryItem.setHidden(true);
				}
			}
		}

		if(config.mediumMode() && containMediumClue) {
			for (Widget inventoryItem : Objects.requireNonNull(inventory.getChildren())) {
				int id = inventoryItem.getItemId();
				if (id == ECLECTIC_IMPLING_JAR || id == ESSENCE_IMPLING_JAR) {
					inventoryItem.setHidden(true);
				}
			}
		}

		if(config.hardMode() && containHardClue) {
			for (Widget inventoryItem : Objects.requireNonNull(inventory.getChildren())) {
				int id = inventoryItem.getItemId();
				if (id == MAGPIE_IMPLING_JAR || id == NINJA_IMPLING_JAR || id == NATURE_IMPLING_JAR) {
					inventoryItem.setHidden(true);
				}
			}
		}

		if(config.eliteMode() && containEliteClue) {
			for (Widget inventoryItem : Objects.requireNonNull(inventory.getChildren())) {
				int id = inventoryItem.getItemId();
				if (id == DRAGON_IMPLING_JAR || id == CRYSTAL_IMPLING_JAR) {
					inventoryItem.setHidden(true);
				}
			}
		}


	}

	/**
	 * Ensure the open impling option exists as long as
	 * there isn't a corresponding clue in inventory
	 */
	private void resetContains() {
		easyClueScan = false;
		mediumClueScan = false;
		hardClueScan = false;
		eliteClueScan = false;
	}
}
