//package com.flashcards.gateway.client;
//
//import com.flashcards.gateway.proto.Flashcard;
//import com.flashcards.gateway.proto.FlashcardSet;
//import com.flashcards.gateway.proto.FlashcardSetServiceGrpc;
//import com.flashcards.gateway.proto.GetFlashcardSetByIdRequest;
//import com.flashcards.gateway.proto.GetFlashcardSetByIdResponse;
//import com.flashcards.gateway.proto.FlashcardSetServiceGrpc.FlashcardSetServiceBlockingStub;
//import com.flashcards.gateway.proto.FlashcardSetServiceGrpc.FlashcardSetServiceStub;
//
//import com.flashcards.gateway.service.impl.FlashcardSetService;
//import io.grpc.Channel;
//import io.grpc.stub.StreamObserver;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.slf4j.Logger;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.UUID;
//
//public class FlashcardSetClient extends FlashcardSetServiceGrpc.FlashcardSetServiceImplBase {
//
//    private static Log log = LogFactory.getLog(FlashcardSetClient.class);
//
//    private final FlashcardSetServiceBlockingStub blockingStub;
//    private final FlashcardSetServiceStub asyncStub;
//
//    public FlashcardSetClient(Channel channel) {
//        blockingStub = FlashcardSetServiceGrpc.newBlockingStub(channel);
//        asyncStub = FlashcardSetServiceGrpc.newStub(channel);
//    }
//
//    @Override
//    public FlashcardSet getFlashcardSetById(UUID flashcardSetId) {
//
//        StreamObserver<GetFlashcardSetByIdRequest> responseObserver = new ServerCallStreamObserverImpl<GetFlashcardSetByIdRequest>();
//        GetFlashcardSetByIdResponse getFlashcardSetByIdResponse;
//        GetFlashcardSetByIdRequest getFlashcardSetByIdRequest = GetFlashcardSetByIdRequest
//                .newBuilder()
//                .setFlashcardSetId(flashcardSetId.toString())
//                .build();
//        try {
//            getFlashcardSetByIdResponse = blockingStub.getFlashcardSetById(getFlashcardSetByIdRequest);
//            asyncStub.getFlashcardSetById(getFlashcardSetByIdRequest, getFlashcardSetByIdResponse);
////            LinkedList<Flashcard> flashcards;
////
////
////            if (getFlashcardSetByIdResponse.hasFlashcardSet()) {
////
////                for (Flashcard flashcard : getFlashcardSetByIdResponse.getFlashcardSet().getFlashcardsList()) {
////                    flashcards.add(flashcardBuilder
////                            .id(flashcard.getId())
////                            .name(flashcard.getName())
////                            .definition(flashcard.getDefinition())
////                            .notes(flashcard.getNotes())
////                            .build());
////                }
////
////                flashcardSetBuilder
////                        .id(UUID.fromString(getFlashcardSetByIdResponse.getFlashcardSet().getId()))
////                        .name(getFlashcardSetByIdResponse.getFlashcardSet().getName())
////                        .description(getFlashcardSetByIdResponse.getFlashcardSet().getDescription())
////                        .flashcards(getFlashcardSetByIdResponse.getFlashcardSet().getFlashcardsList())
////                        .build();
////                getFlashcardSetByIdResponse.getFlashcardSet().
////            }
//            return getFlashcardSetByIdResponse.getFlashcardSet();
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        }
//    }
//}
