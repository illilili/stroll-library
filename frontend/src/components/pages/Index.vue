<template>
  <v-container fluid>
    <v-row>
      <v-card
          v-for="(card, index) in cards"
          :key="index"
          class="mx-auto"
          style="height:300px; width:300px; margin-bottom:20px;"
          outlined
      >
        <v-list-item>
          <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
        </v-list-item>
        <v-card-actions>
          <v-btn
              class="mx-auto"
              outlined
              rounded
              :to="card.link"
              style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
          >
              {{ card.text }}
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: [
      {
          text: "작가 프로필",
          link: "/writerProfiles",
      },
      {
          text: "포트폴리오",
          link: "/portfolios",
      },
      {
          text: "작가 등록 요청 목록",
          link: "/writerRegistrationLists",
      },
      {
          text: "작가 등록 요청 상세",
          link: "/writerRegistrationDetails",
      },
      {
          text: "포트폴리오 상세",
          link: "/portfolioDetails",
      },
      {
          text: "포트폴리오 목록",
          link: "/portfolioLists",
      },
      {
          text: "글",
          link: "/contents",
      },
      {
          text: "출간 요청",
          link: "/publicationRequests",
      },
      {
          text: "출간 메타데이터",
          link: "/publicationMetadata",
      },
      {
          text: "임시 저장 글 목록",
          link: "/contentDraftLists",
      },
      {
          text: "글 상세 정보",
          link: "/contentDetails",
      },
      {
          text: "출간 요청 이력",
          link: "/publicationRequestHistories",
      },
      {
          text: "최종 저장 글 목록",
          link: "/contentFinalLists",
      },
      {
          text: "출간 메타데이터 상세",
          link: "/publicationMetadataDetails",
      },
      {
          text: "출간 메타데이터 목록",
          link: "/publicationMetadataLists",
      },
      {
          text: "프로모션 메시지",
          link: "/promotionMessages",
      },
      {
          text: "사용자",
          link: "/users",
      },
      {
          text: "포인트 지갑",
          link: "/pointWallets",
      },
      {
          text: "구독",
          link: "/subscriptions",
      },
      {
          text: "유도 메시지 이력",
          link: "/promotionMessageHistories",
      },
      {
          text: "현재 유도 메시지",
          link: "/promotionMessageCurrents",
      },
      {
          text: "포인트 내역 조회",
          link: "/userPointHistories",
      },
      {
          text: "사용자 프로필 조회",
          link: "/userProfiles",
      },
      {
          text: "포인트 지갑 잔액",
          link: "/pointWalletBalances",
      },
      {
          text: "포인트 지갑 변동 이력",
          link: "/pointWalletHistories",
      },
      {
          text: "구독 상태 조회",
          link: "/subscriptionStatuses",
      },
      {
          text: "구독 이력 조회",
          link: "/subscriptionHistories",
      },
      {
          text: "커버 이미지",
          link: "/coverImages",
      },
      {
          text: "줄거리 설명",
          link: "/summaries",
      },
      {
          text: "변환된 원고",
          link: "/convertedManuscripts",
      },
      {
          text: "카테고리 및 요금",
          link: "/categoryAndFees",
      },
      {
          text: "줄거리 상세",
          link: "/summaryDetails",
      },
      {
          text: "변환 결과 상세",
          link: "/convertedManuscriptDetails",
      },
      {
          text: "변환 결과 목록",
          link: "/convertedManuscriptLists",
      },
      {
          text: "카테고리 및 요금 상세",
          link: "/categoryAndFeeDetails",
      },
      {
          text: "카테고리 및 요금 목록",
          link: "/categoryAndFeeLists",
      },
      {
          text: "커버이미지 상세",
          link: "/coverImageDetails",
      },
      {
          text: "도서",
          link: "/books",
      },
      {
          text: "배지",
          link: "/badges",
      },
      {
          text: "도서 목록",
          link: "/bookLists",
      },
      {
          text: "배지 부여 내역",
          link: "/badgeHistories",
      },
    ],
  }),
};
</script>
