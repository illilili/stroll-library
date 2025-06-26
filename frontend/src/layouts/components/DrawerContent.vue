<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '작가 관리' }" />
        <VerticalNavLink
            :item="{
                title: '작가 프로필',
                to: '/writerProfiles',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포트폴리오',
                to: '/portfolios',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가 등록 요청 목록',
                to: '/writerRegistrationLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가 등록 요청 상세',
                to: '/writerRegistrationDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포트폴리오 상세',
                to: '/portfolioDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포트폴리오 목록',
                to: '/portfolioLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '콘텐츠 출간' }" />
        <VerticalNavLink
            :item="{
                title: '글',
                to: '/contents',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 요청',
                to: '/publicationRequests',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 메타데이터',
                to: '/publicationMetadata',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '임시 저장 글 목록',
                to: '/contentDraftLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '글 상세 정보',
                to: '/contentDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 요청 이력',
                to: '/publicationRequestHistories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '최종 저장 글 목록',
                to: '/contentFinalLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 메타데이터 상세',
                to: '/publicationMetadataDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 메타데이터 목록',
                to: '/publicationMetadataLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '구독 및 포인트' }" />
        <VerticalNavLink
            :item="{
                title: '프로모션 메시지',
                to: '/promotionMessages',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '사용자',
                to: '/users',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포인트 지갑',
                to: '/pointWallets',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독',
                to: '/subscriptions',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '유도 메시지 이력',
                to: '/promotionMessageHistories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '현재 유도 메시지',
                to: '/promotionMessageCurrents',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포인트 내역 조회',
                to: '/userPointHistories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '사용자 프로필 조회',
                to: '/userProfiles',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포인트 지갑 잔액',
                to: '/pointWalletBalances',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포인트 지갑 변동 이력',
                to: '/pointWalletHistories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독 상태 조회',
                to: '/subscriptionStatuses',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독 이력 조회',
                to: '/subscriptionHistories',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'AI 서비스' }" />
        <VerticalNavLink
            :item="{
                title: '커버 이미지',
                to: '/coverImages',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '줄거리 설명',
                to: '/summaries',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '변환된 원고',
                to: '/convertedManuscripts',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '카테고리 및 요금',
                to: '/categoryAndFees',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '줄거리 상세',
                to: '/summaryDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '변환 결과 상세',
                to: '/convertedManuscriptDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '변환 결과 목록',
                to: '/convertedManuscriptLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '카테고리 및 요금 상세',
                to: '/categoryAndFeeDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '카테고리 및 요금 목록',
                to: '/categoryAndFeeLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '커버이미지 상세',
                to: '/coverImageDetails',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '도서 상태 처리' }" />
        <VerticalNavLink
            :item="{
                title: '도서',
                to: '/books',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '배지',
                to: '/badges',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '도서 목록',
                to: '/bookLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '배지 부여 내역',
                to: '/badgeHistories',
            }"
        />
    </ul>
</template>
